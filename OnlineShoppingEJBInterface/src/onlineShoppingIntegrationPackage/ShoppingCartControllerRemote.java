/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlineShoppingIntegrationPackage;

import javax.ejb.Remote;

/**
 *
 * @author Saiful
 */
@Remote
public interface ShoppingCartControllerRemote {

    boolean AddShoppingCart(String _customerInfo, String _productInfo, String _userName);

    int GetMaxCartId();
    
}
