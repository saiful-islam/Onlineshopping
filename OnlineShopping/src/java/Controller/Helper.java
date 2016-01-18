/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import onlineShoppingIntegrationPackage.ProductControllerRemote;

/**
 *
 * @author Saiful
 */
public class Helper {

    ProductControllerRemote productController = lookupProductControllerRemote();
    public String GetAllProduct()
    {
        return productController.GetAllProducts();
    }

    private ProductControllerRemote lookupProductControllerRemote() {
        try {
            Context c = new InitialContext();
            return (ProductControllerRemote) c.lookup("java:global/OnlineShoppingEJB/OnlineShoppingEJB-ejb/ProductController!onlineShoppingIntegrationPackage.ProductControllerRemote");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
