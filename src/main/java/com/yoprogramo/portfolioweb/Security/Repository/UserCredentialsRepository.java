package com.yoprogramo.portfolioweb.Security.Repository;

import com.yoprogramo.portfolioweb.Security.Model.Role;
import com.yoprogramo.portfolioweb.Security.Model.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCredentialsRepository extends JpaRepository<UserCredentials, Integer> {
    UserCredentials findByUserName(String userName);
    
    boolean existsByUserName(String userName);
    
    
    UserCredentials findByRole(Role role);
    
}
