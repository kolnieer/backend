package ProjectBackEnd.backend.NotFoundException;

public class AddOnsNotFoundException extends RuntimeException{
    public AddOnsNotFoundException(Long addOnsId){
        super("Could not found an add ons with " + addOnsId);
    }

}
