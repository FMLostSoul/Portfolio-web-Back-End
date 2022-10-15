package com.yoprogramo.portfolioweb.Repository;

import com.yoprogramo.portfolioweb.Model.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends JpaRepository<Url, Integer> {
    
}
