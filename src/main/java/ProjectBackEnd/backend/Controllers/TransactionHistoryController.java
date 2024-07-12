package ProjectBackEnd.backend.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ProjectBackEnd.backend.Model.TransactionHistory;
import ProjectBackEnd.backend.Repository.TransactionRepository;

@RestController
public class TransactionHistoryController {

    TransactionHistory repo;

    public TransactionHistoryController(TransactionRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/TransactionHistory")
    public List<TransactionHistory> getTransactionHistory(){
        return repo.findAll();
    }

    @GetMapping("TransactionHistory/new")
    public TransactionHistory TransactionHistory(@PathVariable long id){
        return repo.findById(id)
        .orElseThrow(()-> new TransactionHistory(id));

    }

    public String addTransactioString(@PathVariable long id, @RequestBody TransactionHistory newTransactionHistory){
        repo.save(newTransactionHistory);
        return "A new delivery has been added";
    }

    @PutMapping("/TransactionHistory/edit/{id}")
    public TransactionHistory updateTransactionHistory(@PathVariable long id,@RequestBody TransactionHistory newTransactionHistory){
        return repo.findById(id)
        .map(TransactionHistory -> {
        TransactionHistory.setReserveId(newTransactionHistory.getReserveId());
        TransactionHistory.setDeliveryId(newTransactionHistory.getDeliveryId());
        TransactionHistory.setOrderId(newTransactionHistory.getOrderId());
        return repo.save(TransactionHistory);
    }).orElseGet(()->{
        return repo.save(newTransactionHistory);
    });
     

    }

    public String deleteTransactionHistory(@PathVariable long id){
        repo.deleteById(id);
        return "A Transaction has been cancelled";
    }

}
