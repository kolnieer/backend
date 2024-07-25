package ProjectBackEnd.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ProjectBackEnd.backend.Model.Reservation;

public interface ReservationRepository extends JpaRepository <Reservation, Long> {



}