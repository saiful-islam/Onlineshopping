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
@Table(name = "cartproduct")
public class cartproduct implements Serializable {
    private static final long serialVersionUID = 8633415090390966715L;
    @Id
    @Column(name = "cartid")
    private int cartid;

    @Id
    @Column(name = "productid")
    private int productid;

    public void SetCartId(int _cartid) {
        this.cartid = _cartid;
    }

    public int GetCartId() {
        return this.cartid;
    }

    public void SetProductId(int _productId) {
        this.productid = _productId;
    }

    public int GetProductId() {
        return this.productid;
    }
}
