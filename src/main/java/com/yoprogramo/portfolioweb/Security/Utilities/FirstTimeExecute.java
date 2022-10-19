package com.yoprogramo.portfolioweb.Security.Utilities;

import com.yoprogramo.portfolioweb.Model.Url;
import com.yoprogramo.portfolioweb.Model.UserProfile;
import com.yoprogramo.portfolioweb.Repository.UrlRepository;
import com.yoprogramo.portfolioweb.Security.Enum.RoleName;
import com.yoprogramo.portfolioweb.Security.Model.Role;
import com.yoprogramo.portfolioweb.Security.Service.IRoleService;
import com.yoprogramo.portfolioweb.Service.IUserProfileService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class FirstTimeExecute implements CommandLineRunner {

    
    @Autowired
    IUserProfileService userService;
    
    @Autowired
    UrlRepository urlRepository;
    
    @Autowired
    IRoleService roleService;

    @Override
    public void run(String... args) throws Exception {
     
        Role rolAdmin = new Role(RoleName.ROLE_ADMIN);
        Role rolUser = new Role(RoleName.ROLE_USER); // No se usa por ahora.
        roleService.save(rolAdmin);
        roleService.save(rolUser);
        
        
        Url url1 = new Url("a");
        Url url2 = new Url("b");
        List<Url> urls = new ArrayList<>();
        urls.add(url1);
        urls.add(url2);
        urlRepository.save(url1);
        urlRepository.save(url2);
        
        UserProfile firstUser = new UserProfile("userName","careerInfo","email", urls);
        userService.saveInfo(firstUser);
        
    
    }
}

