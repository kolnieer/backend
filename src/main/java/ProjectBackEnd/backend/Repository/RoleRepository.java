package ProjectBackEnd.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ProjectBackEnd.backend.Model.Role;



public interface RoleRepository extends JpaRepository<Role, Long>{
    Role findByName(String name);

}
