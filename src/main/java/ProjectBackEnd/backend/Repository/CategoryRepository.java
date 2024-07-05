package ProjectBackEnd.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ProjectBackEnd.backend.Model.Category;

public interface CategoryRepository extends JpaRepository <Category, Long> {

}
