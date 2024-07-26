package ProjectBackEnd.backend.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ProjectBackEnd.backend.Model.Reservation;
import ProjectBackEnd.backend.NotFoundException.ReservationNotFoundException;
import ProjectBackEnd.backend.Repository.ReservationRepository;



@RestController
@RequestMapping("/api/v1/reservation")
public class ReservationController {

    ReservationRepository repo;

    public ReservationController(ReservationRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/all")
    public List<Reservation> getReservations(){
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Reservation getReservations(@PathVariable Long id){
        return repo.findById(id)
        .orElseThrow(()-> new ReservationNotFoundException(id));

    }

    @PostMapping("/new")
    public String addReservation(@RequestBody Reservation newReservation){
        repo.save(newReservation);
        return "A new reservation has been added";
    }

    @PutMapping("/edit/{id}")
    public Reservation updatReservation(@PathVariable Long id,@RequestBody Reservation newReservation){
        return repo.findById(id)
        .map(reservation -> {
        reservation.setProductId(newReservation.getProductId());
        reservation.setOrderId(newReservation.getOrderId());
        return repo.save(reservation);
    }).orElseGet(()->{
        return repo.save(newReservation);
    });
     

    }

    @DeleteMapping("/delete/{id}")
    public String deleteDelivery(@PathVariable Long id){
        repo.deleteById(id);
        return "A Delivery has been deleted";
    }

}

