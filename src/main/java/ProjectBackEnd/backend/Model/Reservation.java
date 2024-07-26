package ProjectBackEnd.backend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Reservation {



    @Id
    @GeneratedValue Long reservationId;
    private Long productId;
    private long orderId;


    Reservation(){}


    public Reservation(Long reservationId, Long productId, long orderId) {
        this.reservationId = reservationId;
        this.productId = productId;
        this.orderId = orderId;
    }


    public Long getId() {
        return reservationId;
    }


    public void setId(Long reservationId) {
        this.reservationId = reservationId;
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

