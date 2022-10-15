package com.yoprogramo.portfolioweb.Security.Service;

import com.yoprogramo.portfolioweb.Security.Model.Role;
import com.yoprogramo.portfolioweb.Security.Model.UserCredentials;
import com.yoprogramo.portfolioweb.Security.Repository.RoleRepository;
import com.yoprogramo.portfolioweb.Security.Repository.UserCredentialsRepository;
import com.yoprogramo.portfolioweb.Security.Enum.RoleName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleService implements IRoleService {

    @Autowired
    UserCredentialsRepository userCred;

    @Autowired
    RoleRepository roleRepository;

    public Role getByRoleName(Role role) {
        return roleRepository.findByRoleName(role.getRoleName());
    }

    public void save(Role rol) {
        roleRepository.save(rol);
    }

    public void addRoleToUser(String userName, RoleName role) {
        UserCredentials user = userCred.findByUserName(userName);
        Role userRole = roleRepository.findByRoleName(role);
        if (user != null && userRole != null) {
            user.getRole().add(userRole);
            userCred.save(user);
        }
    }
}
