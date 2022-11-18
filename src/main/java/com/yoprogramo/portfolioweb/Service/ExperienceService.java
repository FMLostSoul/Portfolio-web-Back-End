/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yoprogramo.portfolioweb.Service;

import com.yoprogramo.portfolioweb.Model.ExpCard;
import com.yoprogramo.portfolioweb.Repository.ExpCRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienceService implements IExperienceService {

    @Autowired
    ExpCRepository expRepo;
    
    @Override
    public void saveExp(ExpCard newCard) {
       expRepo.save(newCard);
    }
    
    

    @Override
    public List<ExpCard> getExps() {
       List<ExpCard> listaTarjetas = expRepo.findAll();
        return listaTarjetas;
    }

    @Override
    public void deleteExp(int id) {
        expRepo.deleteById(id);
    }

    @Override
    public ExpCard findExp(int id) {
        ExpCard searchedCard;
        searchedCard = expRepo.findById(id).orElse(null);
        return searchedCard;
    }

    @Override
    public void updateExp(ExpCard oldCard, String newTitle, String newBody) {
        if (!(newTitle.isEmpty())) {
            oldCard.setTitle(newTitle);
        }
        if (!(newBody.isEmpty())) {
            oldCard.setBody(newBody);
        }
    }
    
}
