package ProjectBackEnd.backend.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import ProjectBackEnd.backend.Model.AddOns;


public interface AddonsRepository extends JpaRepository <AddOns, Long> {
    AddOns findByAddOnsId(Long addOnsId);
}
