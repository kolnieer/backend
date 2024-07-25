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

import ProjectBackEnd.backend.Model.OrderDetails;
import ProjectBackEnd.backend.NotFoundException.OrderDetailsNotFoundException;
import ProjectBackEnd.backend.Repository.OrderDetailsRepository;

@RestController
@RequestMapping("/api/v1/orderdetails")
public class OrderDetailsController {

    OrderDetailsRepository repo;

    public OrderDetailsController(OrderDetailsRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/all")
    public List<OrderDetails> getOrderDetails(){
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public OrderDetails getOrderDetail(@PathVariable Long id){
        return repo.findById(id)
        .orElseThrow(()-> new OrderDetailsNotFoundException(id));
    }

    @PostMapping("/new")
    public String addOrderDetails(@PathVariable Long id,@RequestBody OrderDetails newDetails){
        repo.save(newDetails);
        return "A new order details has been added";
    }

    @PutMapping("/edit/{id}")
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
    
    @DeleteMapping("/delete/{id}")
    public String deleteOrderDetails(@PathVariable Long id){
        repo.deleteById(id);
        return "An order details has been deleted";
    }
}
