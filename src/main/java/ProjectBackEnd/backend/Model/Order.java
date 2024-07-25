package ProjectBackEnd.backend.Model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ordertbl")
public class Order {

    private @Id
    @GeneratedValue Long orderId;
    private Long userId;
    private Long reservationId;
    private Long deliveryId;
    private double totalAmount;
    private Date orderDate;
    private String reservationStatus;
    private String deliveryStatus;

    Order(){}

    public Order(Long userId, Long reservationId, Long deliveryId, double totalAmount, Date orderDate,
            String reservationStatus, String deliveryStatus) {
        this.userId = userId;
        this.reservationId = reservationId;
        this.deliveryId = deliveryId;
        this.totalAmount = totalAmount;
        this.orderDate = orderDate;
        this.reservationStatus = reservationStatus;
        this.deliveryStatus = deliveryStatus;
    }

    public void setId(Long orderId) {
        this.orderId = orderId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setReserveId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setReserveStatus(String reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public Long getId() {
        return orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getReservationId() {
        return reservationId;
    }

    public Long getDeliveryId() {
        return deliveryId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public String getReservationStatus() {
        return reservationStatus;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    



}
