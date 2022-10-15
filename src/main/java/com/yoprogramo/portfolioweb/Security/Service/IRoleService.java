package com.yoprogramo.portfolioweb.Security.Service;

import com.yoprogramo.portfolioweb.Security.Model.Role;
import com.yoprogramo.portfolioweb.Security.Enum.RoleName;

public interface IRoleService {

    public Role getByRoleName(Role role);

    public void addRoleToUser(String userName, RoleName role);

    public void save(Role rol);
}
