package ProjectBackEnd.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ProjectBackEnd.backend.Model.Role;

import java.util.Optional;



public interface RoleRepository extends JpaRepository<Role, Long>{
    Optional<Role> findByName(String name);

}
