package ProjectBackEnd.backend.NotFoundException;

public class OrderDetailsNotFoundException extends RuntimeException{
    public OrderDetailsNotFoundException(Long id){
        super("Could not found an order with " + id);    
    }
}
