package ProjectBackEnd.backend.Controllers;

import ProjectBackEnd.backend.Repository.UserRepository;
import ProjectBackEnd.backend.DTO.UserDetailDTO;
import ProjectBackEnd.backend.Model.User;
import ProjectBackEnd.backend.Model.UserDetails;
import ProjectBackEnd.backend.NotFoundException.UserDetailsNotFoundException;
import ProjectBackEnd.backend.Repository.UserDetailsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user-deatil")
public class UserDetailsController{

    @Autowired
    UserDetailsRepository UserDetailsRepository;

    @Autowired
    UserRepository UserRepository;

    @PostMapping("/new")
    public ResponseEntity<?> addUserDetailEntity(@RequestBody UserDetailDTO entity) {
        UserDetails userDetail = new UserDetails(
            entity.getMobileNum(), 
            entity.getAddress()
        );
        User user = UserRepository.findByEmail(entity.getEmail());
        userDetail.setUser(user);
        UserDetailsRepository.save(userDetail);
        return new ResponseEntity<>("User details added successfully", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public UserDetails getUser(@PathVariable Long id) {
        return UserDetailsRepository.findById(id)
        .orElseThrow(() -> new UserDetailsNotFoundException(id));
    }

}