package ProjectBackEnd.backend.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ProjectBackEnd.backend.Model.Order;
import ProjectBackEnd.backend.NotFoundException.OrderNotFoundException;
import ProjectBackEnd.backend.Repository.OrderRepository;


@RestController
public class OrderController {

    OrderRepository repo;

    public OrderController(OrderRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/Orders")
    public List<Order> getOrders(){
        return repo.findAll();
    }

    @GetMapping("/Order/{id}")
    public Order getOrder(@PathVariable Long id){
        return repo.findById(id)
        .orElseThrow(()-> new OrderNotFoundException(id));
    }

    @PostMapping("/Order/new")
    public String addOrder(@RequestBody Order newOrder){
        repo.save(newOrder);
        return "A new order has been added!";
    }

    @PutMapping("/Order/edit/{id}")
    public Order updateOrder(@PathVariable Long id,@RequestBody Order newOrder){
        return repo.findById(id)
        .map(order -> {
            order.setUserId(newOrder.getUserId());
            order.setReserveId(newOrder.getReserveId());
            order.setDelieveryId(newOrder.getDelieveryId());
            order.setTotalAmount(newOrder.getTotalAmount());
            order.setOrderDate(newOrder.getOrderDate());
            order.setReserveId(newOrder.getReserveId());
            order.setDelieveryId(newOrder.getDelieveryId());
            return repo.save(order);
        }).orElseGet(()-> {
            return repo.save(newOrder);
        });
    }

    @DeleteMapping("/Order/delete/{id}")
    public String deleteOrder(@PathVariable Long id) {
        repo.deleteById(id);
        return "An order has been sucessfully deleted";
    }

}
