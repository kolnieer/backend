package ProjectBackEnd.backend.NotFoundException;

public class TransactionHistoryNotFoundException extends RuntimeException {
    public TransactionHistoryNotFoundException(Long id){
        super("Could not found product with" + id);
    }
}
