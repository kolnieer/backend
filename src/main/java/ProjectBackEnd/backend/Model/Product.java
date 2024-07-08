package ProjectBackEnd.backend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Product {

    private @Id
    @GeneratedValue Long id;
    private String productName;
    private String description;
    private double smallPrice;
    private double largePrice;
    
    Product(){}

    public Product(String productName, String description, double smallPrice, double largePrice) {
        this.productName = productName;
        this.description = description;
        this.smallPrice = smallPrice;
        this.largePrice = largePrice;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSmallPrice(double smallPrice) {
        this.smallPrice = smallPrice;
    }

    public void setLargePrice(double largePrice) {
        this.largePrice = largePrice;
    }

    public Long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public String getDescription() {
        return description;
    }
    
    public double getSmallPrice() {
        return smallPrice;
    }
    public double getLargePrice() {
        return largePrice;
    }

}

