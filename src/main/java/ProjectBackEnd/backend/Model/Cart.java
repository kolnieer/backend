package ProjectBackEnd.backend.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Cart {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long cartId;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "product_cart",
        joinColumns = 
        {@JoinColumn(name = "cart_Id", referencedColumnName = "cartId")},
        inverseJoinColumns = 
        {@JoinColumn(name = "product_id", referencedColumnName = "id")})
    private Product product;

    @JoinTable(name = "addons_cart",
        joinColumns = 
        {@JoinColumn(name = "cart_Id", referencedColumnName = "cartId")},
        inverseJoinColumns = 
        {@JoinColumn(name = "addOns_Id", referencedColumnName = "addOnsId")})
    
    private Long userId;
    private int quantity;
    

    public Cart(){}


    public Long getCartId() {
        return cartId;
    }


    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }


    public Product getProduct() {
        return product;
    }


    public void setProduct(Product product) {
        this.product = product;
    }


    public Long getUserId() {
        return userId;
    }


    public void setUserId(Long userId) {
        this.userId = userId;
    }


    public int getQuantity() {
        return quantity;
    }


    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}