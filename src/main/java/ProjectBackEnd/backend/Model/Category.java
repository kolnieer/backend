package ProjectBackEnd.backend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Category {

    private @Id
    @GeneratedValue Long id;
    private String productCategory;

    Category(){}

    public Category(String productCategory){
        this.productCategory = productCategory;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setproductCategory(String productCategory){
        this.productCategory = productCategory;
    }

    public Long getId(){
        return id;
    }

    public String getproductCategory(){
        return productCategory;
    }
}
