package ProjectBackEnd.backend.Controllers;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ProjectBackEnd.backend.Model.User;
import ProjectBackEnd.backend.NotFoundException.UserNotFoundException;
import ProjectBackEnd.backend.Repository.UserRepository;

@RestController
public class UserController {

    UserRepository repo;

    public UserController(UserRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/Users")
    public List<User> getUsers(){
        return repo.findAll();
    }

    @GetMapping("/User/{id}")
    public User getUser(@PathVariable Long id){
        return repo.findById(id)
        .orElseThrow(()-> new UserNotFoundException(id));
    }

    @PostMapping("/User/new")
     public String addUser(@RequestBody User newUser){
        repo.save(newUser);
        return "A new user has been added. YEY!";
    }

    @PutMapping("/User/edit/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User newUser){
        return repo.findById(id)
        .map(user -> {
            user.setName(newUser.getName());
            user.setUserName(newUser.getUserName());
            user.setPassword(newUser.getPassword());
            user.setAddress(newUser.getAddress());
            user.setContactInformation(newUser.getContactInformation());
            return repo.save(user);
        }).orElseGet(()->{
            return repo.save(newUser);
        });
    }
    @DeleteMapping("/User/delete/{id}")
    public String deleteUser(@PathVariable Long id){
        repo.deleteById(id);
        return "A user has been deleted!";
    }

}
