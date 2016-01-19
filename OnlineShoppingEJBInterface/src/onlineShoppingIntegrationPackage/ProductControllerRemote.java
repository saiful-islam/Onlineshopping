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
public interface ProductControllerRemote {

    boolean AddProduct(String _productname, float _price);

    int GetMaxProductId();

    String GetAllProducts();

    String GetProduct(int _productId);

    boolean UpdateProduct(int _productId, String _productName, float _price);
    
}
