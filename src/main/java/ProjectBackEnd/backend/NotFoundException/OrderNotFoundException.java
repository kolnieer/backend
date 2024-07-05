package ProjectBackEnd.backend.NotFoundException;

public class OrderNotFoundException extends RuntimeException{
    public OrderNotFoundException(Long id){
        super("Could not found an order with " + id);    
    }
}
