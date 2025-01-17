package ProjectBackEnd.backend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Delivery {

    @Id
    @GeneratedValue Long deliveryId;
    private Long productId;
    private long orderId;


    Delivery(){}


    public Delivery(Long deliveryId, Long productId, long orderId) {
        this.deliveryId = deliveryId;
        this.productId = productId;
        this.orderId = orderId;
    }


    public Long getId() {
        return deliveryId;
    }


    public void setId(Long deliveryId) {
        this.deliveryId = deliveryId;
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
