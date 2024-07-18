package ProjectBackEnd.backend.NotFoundException;

public class CartNotFoundException extends RuntimeException{
    public CartNotFoundException(Long cartId){
        super("Could not found a cart with " + cartId);
    }

}
