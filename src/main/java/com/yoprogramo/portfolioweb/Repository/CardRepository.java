package com.yoprogramo.portfolioweb.Repository;

import com.yoprogramo.portfolioweb.Model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {

}
