package onlineShoppingIntegrationPackage;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shoppingcart")
public class shoppingcart implements Serializable {
    private static final long serialVersionUID = 8633415090391066715L;
    @Id
    @Column(name = "cartid")
    private int cartid;

    @Column(name = "username")
    private String username;

    @Column(name = "price")
    private float price;

    @Column(name = "delivaryaddress")
    private String delivaryaddress;

    @Column(name = "date")
    private Date date;

    @Column(name = "phoneno")
    private String phoneno;

    public void SetCartId(int _cartid) {
        this.cartid = _cartid;
    }

    public int GetCartId() {
        return this.cartid;
    }

    public void SetUserName(String _userName) {
        this.username = _userName;
    }

    public String GetUserName() {
        return this.username;
    }

    public void SetPrice(float _price) {
        this.price = _price;
    }

    public float GetPrice() {
        return this.price;
    }
    public void SetDelivaryAddress(String _delivaryaddress) {
        this.delivaryaddress = _delivaryaddress;
    }

    public String GetDelivaryAddress() {
        return this.delivaryaddress;
    }
    
    public void SetDate(Date _date) {
        this.date = _date;
    }

    public Date GetDate() {
        return this.date;
    }
    public void SetPhoneNo(String _phone) {
        this.phoneno = _phone;
    }

    public String GetPhoneNo() {
        return this.phoneno;
    }
}
