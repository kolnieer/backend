package ProjectBackEnd.backend.NotFoundException;

public class DeliveryNotFoundException extends RuntimeException{
    public DeliveryNotFoundException(Long id){
        super("Could not found an delivery with" + id);
    }


}
