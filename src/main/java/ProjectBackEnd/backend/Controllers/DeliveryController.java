package ProjectBackEnd.backend.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ProjectBackEnd.backend.Model.Delivery;
import ProjectBackEnd.backend.NotFoundException.DeliveryNotFoundException;
import ProjectBackEnd.backend.Repository.DeliveryRepository;

@RestController
public class DeliveryController {

    DeliveryRepository repo;

    public DeliveryController(DeliveryRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/Delivery")
    public List<Delivery> getDelivery(){
        return repo.findAll();
    }

    @GetMapping("Delivery/new")
    public Delivery delivery(@PathVariable long id){
        return repo.findById(id)
        .orElseThrow(()-> new DeliveryNotFoundException(id));

    }

    public String addDelivery(@PathVariable long id, @RequestBody Delivery newDelivery){
        repo.save(newDelivery);
        return "A new delivery has been added";
    }

    @PutMapping("/Delivery/edit/{id}")
    public Delivery updatDelivery(@PathVariable long id,@RequestBody Delivery newDelivery){
        return repo.findById(id)
        .map(Delivery -> {
        Delivery.setProductId(newDelivery.getProductId());
        Delivery.setOrderId(newDelivery.getOrderId());
        return repo.save(Delivery);
    }).orElseGet(()->{
        return repo.save(newDelivery);
    });
     

    }

    public String deleteDelivery(@PathVariable long id){
        repo.deleteById(id);
        return "A Delivery has been cancelled";
    }

}
