package ProjectBackEnd.backend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class TransactionHistory {
    private @Id
    @GeneratedValue Long transactionHistoryId;
    private Long orderId;
    private Long reservationId;
    private Long deliveryId;
    private Long productId;
    private Long userId;
    private Long orderDetailsId;


    TransactionHistory (){}

    public TransactionHistory(Long orderId, Long reservationId, Long deliveryId, Long productId, Long userId,
            Long orderDetailsId) {
        this.orderId = orderId;
        this.reservationId = reservationId;
        this.deliveryId = deliveryId;
        this.productId = productId;
        this.userId = userId;
        this.orderDetailsId = orderDetailsId;
    }

    public Long getTransactionHistoryId() {
        return transactionHistoryId;
    }

    public void setTransactionHistoryId(Long transactionHistoryId) {
        this.transactionHistoryId = transactionHistoryId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public Long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getOrderDetailsId() {
        return orderDetailsId;
    }

    public void setOrderDetailsId(Long orderDetailsId) {
        this.orderDetailsId = orderDetailsId;
    }



    

}