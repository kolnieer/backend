package ProjectBackEnd.backend.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ProjectBackEnd.backend.Model.User;

public interface UserRepository extends JpaRepository <User, Long>{
    User findByEmail(String email);
    User findByUsername(String username);
    Optional<User> findByUsernameOrEmail(String username, String email);

    Boolean existsByEmail(String email);
    Boolean existsByUsername(String username);

}