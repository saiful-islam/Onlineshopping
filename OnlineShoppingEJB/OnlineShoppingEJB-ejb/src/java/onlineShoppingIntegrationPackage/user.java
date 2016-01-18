package onlineShoppingIntegrationPackage;





import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class user implements Serializable 
{

 /**
  * serialVersionUID
  */
 private static final long serialVersionUID = 8633415090390999715L;
 @Id
 @Column(name="username")
 private String username;
 
 @Column(name="password")
 private String password;
 
 @Column(name="email")
 private String email;
 
 @Column(name="role")
 private String role;

 public String GetUserName() {
  return username;
 }
 public void SetUserName(String _userName) {
  this.username = _userName;
 }
 public String GetPassword() {
  return password;
 }
 public void SetPassword(String _password) {
  this.password = _password;
 }
 public String GetEMail() {
  return email;
 }
 public void SetEmail(String _email) {
  this.email = _email;
 }
 public String GetRole() {
  return role;
 }
 public void SetRole(String _role) {
  this.role = _role;
 }
}

