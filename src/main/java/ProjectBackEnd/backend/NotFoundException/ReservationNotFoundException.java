package ProjectBackEnd.backend.NotFoundException;

public class ReservationNotFoundException extends RuntimeException{
    public ReservationNotFoundException(Long id){
        super("Could not found an reservation with" + id);
    }


}
