package ProjectBackEnd.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ProjectBackEnd.backend.Model.Order;

public interface OrderRepository extends JpaRepository <Order, Long>{
    
    

}
