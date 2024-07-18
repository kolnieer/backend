package ProjectBackEnd.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ProjectBackEnd.backend.Model.Cart;
import java.util.List;


public interface CartRepository extends JpaRepository <Cart, Long>{
    List<Cart> findAllByUserId(Long userId);

}
