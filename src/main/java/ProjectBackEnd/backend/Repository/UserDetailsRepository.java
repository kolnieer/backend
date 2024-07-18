package ProjectBackEnd.backend.Repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;


public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {
    Optional<UserDetails> findByPhoneNumber(String phoneNumber);
}