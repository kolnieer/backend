package ProjectBackEnd.backend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class OrderDetails {

    private @Id
    @GeneratedValue Long id;
    private Long orderId;
    private Long productId;
    private String medioSize;
    private String grandeSize;
    private String addOns;
    private int sugarLevel;
    private int quantity;

    OrderDetails(){}

    public OrderDetails(Long orderId, Long productId, String medioSize, String grandeSize, String addOns,
            int sugarLevel, int quantity) {
        this.orderId = orderId;
        this.productId = productId;
        this.medioSize = medioSize;
        this.grandeSize = grandeSize;
        this.addOns = addOns;
        this.sugarLevel = sugarLevel;
        this.quantity = quantity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setMedioSize(String medioSize) {
        this.medioSize = medioSize;
    }

    public void setGrandeSize(String grandeSize) {
        this.grandeSize = grandeSize;
    }

    public void setAddOns(String addOns) {
        this.addOns = addOns;
    }

    public void setSugarLevel(int sugarLevel) {
        this.sugarLevel = sugarLevel;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public String getMedioSize() {
        return medioSize;
    }

    public String getGrandeSize() {
        return grandeSize;
    }

    public String getAddOns() {
        return addOns;
    }

    public int getSugarLevel() {
        return sugarLevel;
    }

    public int getQuantity() {
        return quantity;
    }

}
