package com.yoprogramo.portfolioweb.Security.Controller;

import com.yoprogramo.portfolioweb.Security.DTO.JwtDTO;
import com.yoprogramo.portfolioweb.Security.DTO.Login;
import com.yoprogramo.portfolioweb.Security.DTO.NewUser;
import com.yoprogramo.portfolioweb.Security.Model.Role;
import com.yoprogramo.portfolioweb.Security.Model.UserCredentials;
import com.yoprogramo.portfolioweb.Security.Jwt.JwtProvider;
import com.yoprogramo.portfolioweb.Security.Service.IRoleService;
import com.yoprogramo.portfolioweb.Security.Service.IUserCredentialsService;
import com.yoprogramo.portfolioweb.Security.Enum.RoleName;
import com.yoprogramo.portfolioweb.Security.Service.CustomAuthenticationProvider;
import com.yoprogramo.portfolioweb.Security.Service.UserDetailsServiceImpl;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"https://portfolio-angular-80c26.web.app/login", "https://portfolio-angular-80c26.web.app/", "http://localhost:4200/"})
public class AuthController {

    @Autowired
    UserDetailsServiceImpl detailsService;

    @Autowired
    private CustomAuthenticationProvider customAuthenticationProvider;

    @Autowired
    private IRoleService roleService;
    @Autowired
    private IUserCredentialsService userCredentialsService;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/auth/create")
    public ResponseEntity<?> create(@Valid @RequestBody NewUser newUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity("Fields not completed", HttpStatus.BAD_REQUEST);
        }
        if (userCredentialsService.existsByUserName(newUser.getUserName())) {
            return new ResponseEntity("Username already used", HttpStatus.BAD_REQUEST);
        }

        UserCredentials userCredentials
                = new UserCredentials(newUser.getUserName(),
                        customAuthenticationProvider.passwordEncoder.encode(newUser.getPassword()),
                        newUser.getName());
        Set<Role> roles = new HashSet<>();

        userCredentialsService.save(userCredentials);
        roleService.addRoleToUser(userCredentials.getUserName(), RoleName.ROLE_ADMIN);
        return new ResponseEntity("User Created", HttpStatus.CREATED);
    }

    @PostMapping("/auth/login")
    public ResponseEntity<JwtDTO> login(@RequestBody Login login, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity("Invalid Fields", HttpStatus.BAD_REQUEST);
        }
        Authentication auth = customAuthenticationProvider.authenticate(new UsernamePasswordAuthenticationToken(login.getUserName(), login.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(auth);
        String jwt = jwtProvider.generateToken(auth);
        UserDetails userDetails = detailsService.loadUserByUsername(login.getUserName());
        JwtDTO jwtDto = new JwtDTO(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity(jwtDto, HttpStatus.OK);

    }

}
