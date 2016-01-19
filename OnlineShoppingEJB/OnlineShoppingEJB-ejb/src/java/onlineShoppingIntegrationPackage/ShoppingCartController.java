/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlineShoppingIntegrationPackage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Saiful
 */
@Stateless
public class ShoppingCartController implements ShoppingCartControllerRemote {

    @Override
    public boolean AddShoppingCart(String _customerInfo, String _productInfo, String _userName) {
        try {
            shoppingcart objShop = new shoppingcart();

            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            //getting session object from session factory
            Session session = sessionFactory.openSession();
            //getting transaction object from session object
            session.beginTransaction();
            Query query = session.createQuery("from product where productid in(" + _productInfo + ") ");
            List<product> _products = query.list();
            session.getTransaction().commit();
            int cartId = GetMaxCartId();
            float total = (float) 0.00;
            for (product _prod : _products) {
                session.beginTransaction();
                cartproduct objCartProd = new cartproduct();
                objCartProd.SetCartId(cartId);
                objCartProd.SetProductId(_prod.GetProductId());
                session.save(objCartProd);
                System.out.println("Inserted Successfully");
                session.getTransaction().commit();
                total += _prod.GetPrice();
            }
            session.beginTransaction();
            String[] cust = _customerInfo.split(",");
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
            System.out.println(cust[1]);
            Date _date = formatter.parse(cust[1]);

            objShop.SetCartId(cartId);
            objShop.SetPrice(total);
            objShop.SetUserName(_userName);
            objShop.SetDate(_date);
            objShop.SetDelivaryAddress(cust[0]);
            objShop.SetPhoneNo(cust[2]);
            session.save(objShop);
            System.out.println("Inserted Successfully");
            session.getTransaction().commit();

            return true;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public int GetMaxCartId() {
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            //getting session object from session factory
            Session session = sessionFactory.openSession();
            //getting transaction object from session object
            session.beginTransaction();
            Query query = session.createQuery("from shoppingcart");
            int maxId = 0;
            List<shoppingcart> _shopCarts = query.list();

            for (shoppingcart _cart : _shopCarts) {
                int temp = _cart.GetCartId();
                if (temp > maxId) {
                    maxId = temp;
                }
            }
            return maxId + 1;
        } catch (Exception ex) {
            return 1;
        }
    }

}
