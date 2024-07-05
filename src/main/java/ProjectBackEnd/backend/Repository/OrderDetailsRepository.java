package ProjectBackEnd.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ProjectBackEnd.backend.Model.OrderDetails;

public interface OrderDetailsRepository extends JpaRepository <OrderDetails, Long> {

}
