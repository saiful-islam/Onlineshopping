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
public class UserController implements UserControllerRemote {

    @Override
    public boolean AddUser(String _userName, String _password, String _email, String _role) {
        try {
            user objuser = new user();
            objuser.SetUserName(_userName);
            objuser.SetPassword(_password);
            objuser.SetEmail(_email);
            objuser.SetRole(_role);

            //Create session factory object
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            //getting session object from session factory
            Session session = sessionFactory.openSession();
            //getting transaction object from session object
            session.beginTransaction();

            session.save(objuser);
            System.out.println("Inserted Successfully");
            session.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean IsValidUser(String _userName, String _password) {
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            //getting session object from session factory
            Session session = sessionFactory.openSession();
            //getting transaction object from session object
            session.beginTransaction();
            Query query = session.createQuery("from user where username='" + _userName + "'");
            List<user> _users = query.list();
            boolean isValid = false;
            for (user _user : _users) {
                if (_user.GetPassword().equals(_password)) {
                    isValid = true;
                    break;
                }
            }
            return isValid;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public String GetUserRole(String _userName) {
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            //getting session object from session factory
            Session session = sessionFactory.openSession();
            //getting transaction object from session object
            session.beginTransaction();
            Query query = session.createQuery("from user where username='" + _userName + "'");
            List<user> _users = query.list();
            String role = null;
            for (user _user : _users) {
                role = _user.GetRole();
            }
            
            return role;
        } catch (Exception ex) {
            return "";
        }
    }

    @Override
    public boolean IsExists(String _userName) {
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            //getting session object from session factory
            Session session = sessionFactory.openSession();
            //getting transaction object from session object
            session.beginTransaction();
            Query query = session.createQuery("from user where username='" + _userName + "'");
            List<user> _users = query.list();
            boolean isExist = false;
            for (user _user : _users) {
                isExist = true;
                break;
            }
            
            return isExist;
        } catch (Exception ex) {
            return false;
        }
    }

}
