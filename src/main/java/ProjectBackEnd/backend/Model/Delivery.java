package ProjectBackEnd.backend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Delivery {

    private @Id
    @GeneratedValue Long id;
    private Long productId;
    private long orderId;


    Delivery(){}


    public Delivery(Long id, Long productId, long orderId) {
        this.id = id;
        this.productId = productId;
        this.orderId = orderId;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public Long getProductId() {
        return productId;
    }


    public void setProductId(Long productId) {
        this.productId = productId;
    }


    public long getOrderId() {
        return orderId;
    }


    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    

}
