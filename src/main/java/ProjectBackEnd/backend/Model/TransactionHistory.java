package ProjectBackEnd.backend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class TransactionHistory {
    private @Id
    @GeneratedValue Long id;
    private String getReserveId;
    private String getDeliveryId;
    private double getOrderId;


    TransactionHistory (){}


    public TransactionHistory(Long id, String getReserveId, String getDeliveryId, double getOrderId) {
        this.id = id;
        this.getReserveId = getReserveId;
        this.getDeliveryId = getDeliveryId;
        this.getOrderId = getOrderId;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getGetReserveId() {
        return getReserveId;
    }


    public void setGetReserveId(String getReserveId) {
        this.getReserveId = getReserveId;
    }


    public String getGetDeliveryId() {
        return getDeliveryId;
    }


    public void setGetDeliveryId(String getDeliveryId) {
        this.getDeliveryId = getDeliveryId;
    }


    public double getGetOrderId() {
        return getOrderId;
    }


    public void setGetOrderId(double getOrderId) {
        this.getOrderId = getOrderId;
    }


    public Object getDeliveryId() {
        //TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDeliveryId'");
    }

    


}
