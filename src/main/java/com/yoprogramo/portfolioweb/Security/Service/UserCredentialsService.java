package com.yoprogramo.portfolioweb.Security.Service;

import com.yoprogramo.portfolioweb.Security.Model.UserCredentials;
import com.yoprogramo.portfolioweb.Security.Repository.RoleRepository;
import com.yoprogramo.portfolioweb.Security.Repository.UserCredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserCredentialsService implements IUserCredentialsService {

    @Autowired
    UserCredentialsRepository userCred;

    @Autowired
    RoleRepository roleRepo;

    public UserCredentials getByUserName(String userName) {
        return userCred.findByUserName(userName);
    }

    public boolean existsByUserName(String userName) {
        return userCred.existsByUserName(userName);
    }

    public void save(UserCredentials user) {
        userCred.save(user);
    }

}
