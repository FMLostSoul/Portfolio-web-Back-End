package com.yoprogramo.portfolioweb.Repository;

import com.yoprogramo.portfolioweb.Model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserProfile, Integer> {

}
