package ProjectBackEnd.backend.NotFoundException;

public class CategoryNotFoundException  extends RuntimeException {
    public CategoryNotFoundException(Long id){
        super("Could not found category with " + id);
    }

}

