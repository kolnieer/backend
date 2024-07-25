package ProjectBackEnd.backend.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import ProjectBackEnd.backend.Model.TransactionHistory;
import ProjectBackEnd.backend.NotFoundException.TransactionHistoryNotFoundException;
import ProjectBackEnd.backend.Repository.TransactionHistoryRepository;

@RestController
@RequestMapping("/api/v1/transactionhistory")
public class TransactionHistoryController {

    TransactionHistoryRepository repo;
    
    public TransactionHistoryController(TransactionHistoryRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/all")
    public List<TransactionHistory> getTransactionHistories(){
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public TransactionHistory getTransactionHistory(@PathVariable Long id){
        return repo.findById(id)
        .orElseThrow(()-> new TransactionHistoryNotFoundException(id));
    }

}

