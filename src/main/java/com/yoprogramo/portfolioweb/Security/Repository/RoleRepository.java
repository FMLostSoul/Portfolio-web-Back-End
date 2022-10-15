package com.yoprogramo.portfolioweb.Security.Repository;

import com.yoprogramo.portfolioweb.Security.Model.Role;
import com.yoprogramo.portfolioweb.Security.Enum.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRoleName(RoleName role);
}
