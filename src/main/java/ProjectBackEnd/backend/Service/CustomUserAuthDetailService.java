package ProjectBackEnd.backend.Service;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ProjectBackEnd.backend.Model.UserAuth;
import ProjectBackEnd.backend.Repository.UserAuthRepository;

@Service
public class CustomUserAuthDetailService implements UserDetailsService {
     private UserAuthRepository userAuthRepository;

     public CustomUserAuthDetailService(UserAuthRepository userAuthRepository){
        this.userAuthRepository = userAuthRepository;
     }

     public UserDetails loadUserByUsername( String usernameOremail) throws UsernameNotFoundException{
        UserAuth UserAuth = userAuthRepository.findByUsernameOrEmail(usernameOremail, usernameOremail)
            .orElseThrow(()->
            new UsernameNotFoundException("user not found with username or email" + usernameOremail));

        Set<GrantedAuthority> authorities = UserAuth
            .getRoles()
            .stream()
            .map((role)-> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());

        return new org.springframework.security.core.userdetails.User(
            UserAuth.getEmail(),
            UserAuth.getPassword(),
            authorities
        );
    }

}
