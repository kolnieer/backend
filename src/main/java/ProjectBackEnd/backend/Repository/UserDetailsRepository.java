package ProjectBackEnd.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ProjectBackEnd.backend.Model.User;
import ProjectBackEnd.backend.Model.UserDetails;



public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {
   User findByUser(User user);
}