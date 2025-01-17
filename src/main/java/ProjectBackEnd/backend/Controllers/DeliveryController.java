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

import ProjectBackEnd.backend.Model.Delivery;
import ProjectBackEnd.backend.NotFoundException.DeliveryNotFoundException;
import ProjectBackEnd.backend.Repository.DeliveryRepository;

@RestController
@RequestMapping("/api/v1/delivery")
public class DeliveryController {

    DeliveryRepository repo;

    public DeliveryController(DeliveryRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/all")
    public List<Delivery> getDeliveries(){
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Delivery getDelivery(@PathVariable Long id){
        return repo.findById(id)
        .orElseThrow(()-> new DeliveryNotFoundException(id));

    }

    @PostMapping("/new")
    public String addDelivery(@RequestBody Delivery newDelivery){
        repo.save(newDelivery);
        return "A new delivery has been added";
    }

    @PutMapping("/edit/{id}")
    public Delivery updatDelivery(@PathVariable Long id,@RequestBody Delivery newDelivery){
        return repo.findById(id)
        .map(delivery -> {
        delivery.setProductId(newDelivery.getProductId());
        delivery.setOrderId(newDelivery.getOrderId());
        return repo.save(delivery);
    }).orElseGet(()->{
        return repo.save(newDelivery);
    });
     

    }

    @DeleteMapping("/delete/{id}")
    public String deleteDelivery(@PathVariable Long id){
        repo.deleteById(id);
        return "A Delivery has been deleted";
    }

}
