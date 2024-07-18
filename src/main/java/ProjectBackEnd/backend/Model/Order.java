package ProjectBackEnd.backend.Model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "order")
public class Order {

    private @Id
    @GeneratedValue Long id;
    private Long userId;
    private Long reserveId;
    private Long delieveryId;
    private double totalAmount;
    private Date orderDate;
    private String reserveStatus;
    private String deliveryStatus;

    Order(){}

    public Order(Long userId, Long reserveId, Long delieveryId, double totalAmount, Date orderDate,
            String reserveStatus, String deliveryStatus) {
        this.userId = userId;
        this.reserveId = reserveId;
        this.delieveryId = delieveryId;
        this.totalAmount = totalAmount;
        this.orderDate = orderDate;
        this.reserveStatus = reserveStatus;
        this.deliveryStatus = deliveryStatus;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setReserveId(Long reserveId) {
        this.reserveId = reserveId;
    }

    public void setDelieveryId(Long delieveryId) {
        this.delieveryId = delieveryId;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setReserveStatus(String reserveStatus) {
        this.reserveStatus = reserveStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getReserveId() {
        return reserveId;
    }

    public Long getDelieveryId() {
        return delieveryId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public String getReserveStatus() {
        return reserveStatus;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    



}
