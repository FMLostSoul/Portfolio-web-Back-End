package com.yoprogramo.portfolioweb.Security.Service;

import com.yoprogramo.portfolioweb.Security.Model.UserCredentials;

public interface IUserCredentialsService {

    public UserCredentials getByUserName(String userName);

    public boolean existsByUserName(String userName);

    public void save(UserCredentials user);
}
