/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlineShoppingIntegrationPackage;

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
public class ProductController implements ProductControllerRemote {

    @Override
    public boolean AddProduct(String _productname, float _price) {
        try {
            product objProduct = new product();
            objProduct.SetProductId(GetMaxProductId());
            objProduct.SetProductName(_productname);
            objProduct.SetPrice(_price);

            //Create session factory object
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            //getting session object from session factory
            Session session = sessionFactory.openSession();
            //getting transaction object from session object
            session.beginTransaction();

            session.save(objProduct);
            System.out.println("Inserted Successfully");
            session.getTransaction().commit();
            session.close();
            sessionFactory.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public int GetMaxProductId() {
        try{
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        //getting session object from session factory
        Session session = sessionFactory.openSession();
        //getting transaction object from session object
        session.beginTransaction();
        Query query = session.createQuery("from product");
        int maxId = 0;
        List<product> _products = query.list();

        for (product _prod : _products) {
            int temp = _prod.GetProductId();
            if (temp > maxId) {
                maxId = temp;
            }
        }
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        return maxId + 1;
        } catch (Exception ex) {
            return 1;
        }
    }

    @Override
    public String GetAllProducts() {
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            //getting session object from session factory
            Session session = sessionFactory.openSession();
            //getting transaction object from session object
            session.beginTransaction();
            Query query = session.createQuery("from product");
            List<product> _products = query.list();
            String productList = "";
            for (product _prod : _products) {
                String temp = _prod.GetProductId() + "," + _prod.GetProductName() + "," + _prod.GetPrice();
                productList += "|" + temp;
            }
            session.getTransaction().commit();
            session.close();
            sessionFactory.close();
            return productList.substring(1);
        } catch (Exception ex) {
            return "";
        }

    }

    @Override
    public String GetProduct(int _productId) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        //getting session object from session factory
        Session session = sessionFactory.openSession();
        //getting transaction object from session object
        session.beginTransaction();
        Query query = session.createQuery("from product where productid=" + _productId);
        Object _product = query.uniqueResult();
        product _prod = (product) _product;
        return _prod.GetProductId() + "," + _prod.GetProductName() + "," + _prod.GetPrice();
    }

}
