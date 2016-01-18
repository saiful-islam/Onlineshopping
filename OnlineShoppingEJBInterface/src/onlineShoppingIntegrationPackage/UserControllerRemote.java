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
public interface UserControllerRemote {

    boolean AddUser(String _userName, String _password, String _email, String _role);

    boolean IsValidUser(String _userName, String _password);

    String GetUserRole(String _userName);

    boolean IsExists(String _userName);
    
}
