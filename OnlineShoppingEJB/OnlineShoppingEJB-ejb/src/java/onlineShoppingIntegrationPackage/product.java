package onlineShoppingIntegrationPackage;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class product implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 8633415090390966715L;
    @Id
    @Column(name = "productid")
    private int productid;

    @Column(name = "productname")
    private String productname;

    @Column(name = "price")
    private float price;

    public void SetProductId(int _productId) {
        this.productid = _productId;
    }

    public int GetProductId() {
        return this.productid;
    }

    public void SetProductName(String _productName) {
        this.productname = _productName;
    }

    public String GetProductName() {
        return this.productname;
    }

    public void SetPrice(float _price) {
        this.price = _price;
    }

    public float GetPrice() {
        return this.price;
    }
}
