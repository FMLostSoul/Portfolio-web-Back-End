package com.yoprogramo.portfolioweb.Security.Service;

import com.yoprogramo.portfolioweb.Security.Model.PrivilegedUser;
import com.yoprogramo.portfolioweb.Security.Model.UserCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    IUserCredentialsService userCredSer;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserCredentials user = userCredSer.getByUserName(username);
        return PrivilegedUser.build(user);

    }

}
