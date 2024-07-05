package ProjectBackEnd.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ProjectBackEnd.backend.Model.User;

public interface UserRepository extends JpaRepository <User, Long>{

}
