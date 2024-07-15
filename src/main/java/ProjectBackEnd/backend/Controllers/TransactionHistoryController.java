package ProjectBackEnd.backend.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ProjectBackEnd.backend.Model.TransactionHistory;
import ProjectBackEnd.backend.NotFoundException.TransactionHistoryNotFoundException;
import ProjectBackEnd.backend.Repository.TransactionHistoryRepository;

@RestController
public class TransactionHistoryController {

    TransactionHistoryRepository repo;
    
    public TransactionHistoryController(TransactionHistoryRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/TransactionHistory")
    public List<TransactionHistory> getTransactionHistory(){
        return repo.findAll();
    }

    @GetMapping("/TransactionHistory/{id}")
    public TransactionHistory getTransactionHistory(@PathVariable Long id){
        return repo.findById(id)
        .orElseThrow(()-> new TransactionHistoryNotFoundException(id));
    
    }

    @PostMapping("/TransactionHistory/new")
    public String addProduct(@RequestBody TransactionHistory newTransactionHistory){
        repo.save(newTransactionHistory);
        return "A new transaction history has been added";
    }

    @PutMapping("/TransactionHistory/edit/{id}")
    public TransactionHistory updateTransactionHistory(@PathVariable Long id, @RequestBody TransactionHistory newTransactionHistory){
        return repo.findById(id)
        .map(TransactionHistory ->{
            TransactionHistory.setGetDeliveryId(newTransactionHistory.getGetDeliveryId());
            TransactionHistory.setGetOrderId(newTransactionHistory.getGetOrderId());
            TransactionHistory.setGetReserveId(newTransactionHistory.getGetReserveId());
            return repo.save(newTransactionHistory);
        }).orElseGet(()->{
            return repo.save(newTransactionHistory);
        });
    }
    

    @DeleteMapping("/TransactionHistory/delete/{id}")
    public String deleteTransactionHistory(@PathVariable Long id){
        repo.deleteById(id);
        return "A Transaction has been deleted!";
    }

}

