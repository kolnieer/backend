package ProjectBackEnd.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ProjectBackEnd.backend.Model.Product;


public interface ProductRepository extends JpaRepository <Product, Long>{
    Product findByProductName(String productName);

}


