package ProjectBackEnd.backend.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ProjectBackEnd.backend.Model.OrderDetails;
import ProjectBackEnd.backend.NotFoundException.OrderDetailsNotFoundException;
import ProjectBackEnd.backend.Repository.OrderDetailsRepository;

@RestController
public class OrderDetailsController {

    OrderDetailsRepository repo;

    public OrderDetailsController(OrderDetailsRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/OrderDetails")
    public List<OrderDetails> getOrderDetails(){
        return repo.findAll();
    }

    @GetMapping("/OrderDetails/new")
    public OrderDetails gOrderDetails(@PathVariable Long id){
        return repo.findById(id)
        .orElseThrow(()-> new OrderDetailsNotFoundException(id));
    }

    public String addOrderDetails(@PathVariable Long id,@RequestBody OrderDetails newDetails){
        repo.save(newDetails);
        return "A new order details has been added";
    }

    @PutMapping("/OrderDetails/edit/{id}")
    public OrderDetails updateOrderDetails(@PathVariable Long id,@RequestBody OrderDetails newDetails) {
        return repo.findById(id)
        .map(details -> {
            details.setOrderId(newDetails.getOrderId());
            details.setProductId(newDetails.getProductId());
            details.setMedioSize(newDetails.getMedioSize());
            details.setGrandeSize(newDetails.getGrandeSize());
            details.setAddOns(newDetails.getAddOns());
            details.setSugarLevel(newDetails.getSugarLevel());
            details.setQuantity(newDetails.getQuantity());
            return repo.save(details);
        }).orElseGet(()->{
            return repo.save(newDetails);
        });
    }
    
    public String deleteOrderDetails(@PathVariable Long id){
        repo.deleteById(id);
        return "An order details has been deleted";
    }
}
