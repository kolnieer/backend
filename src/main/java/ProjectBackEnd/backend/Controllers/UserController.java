package ProjectBackEnd.backend.Controllers;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ProjectBackEnd.backend.DTO.LoginRequest;
import ProjectBackEnd.backend.DTO.RegistrationRequest;
import ProjectBackEnd.backend.Model.Role;
import ProjectBackEnd.backend.Model.User;
import ProjectBackEnd.backend.Repository.RoleRepository;
import ProjectBackEnd.backend.Repository.UserRepository;

@RestController
@RequestMapping("api/v1/auth")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/register/admin")
    public ResponseEntity<?> registerAdmin(@RequestBody RegistrationRequest entity) {
        //check if user exist
        if(userRepository.existsByUsername(passwordEncoder.encode(entity.getName()+entity.getEmail()))){
            return new ResponseEntity<>("An account already exist with similar credentials", HttpStatus.BAD_REQUEST);
        }
        if(userRepository.existsByEmail(entity.getEmail())){
            return new ResponseEntity<>("An account is already created with this email", HttpStatus.BAD_REQUEST);
        }
        
        User user = new User(
            entity.getName(), 
            passwordEncoder.encode(entity.getName()+entity.getEmail()), 
            entity.getEmail(), 
            passwordEncoder.encode(entity.getPassword())
            );

        Role role = roleRepository.findByName("ROLE_ADMIN");
        user.setRoles(Collections.singleton(role));

        userRepository.save(user);
        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }

    @PostMapping("/register/user")
    public ResponseEntity<?> registerUser(@RequestBody RegistrationRequest entity) {
        //check if user exist
        if(userRepository.existsByUsername(passwordEncoder.encode(entity.getName()+entity.getEmail()))){
            return new ResponseEntity<>("An account already exist with similar credentials", HttpStatus.BAD_REQUEST);
        }
        if(userRepository.existsByEmail(entity.getEmail())){
            return new ResponseEntity<>("An account is already created with this email", HttpStatus.BAD_REQUEST);
        }
        
        User user = new User(
            entity.getName(), 
            passwordEncoder.encode(entity.getName()+entity.getEmail()), 
            entity.getEmail(), 
            passwordEncoder.encode(entity.getPassword())
            );

        Role role = roleRepository.findByName("ROLE_USER");
        user.setRoles(Collections.singleton(role));

        userRepository.save(user);
        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> logEntity(@RequestBody LoginRequest entity) {
        try{
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    entity.getUsernameOrEmail(), 
                    entity.getPassword()
                    )
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);
            return new ResponseEntity<>("User logged in successfully", HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
        }
    }
    
}