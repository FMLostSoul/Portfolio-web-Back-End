/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yoprogramo.portfolioweb.Service;

import com.yoprogramo.portfolioweb.Model.EduCard;
import com.yoprogramo.portfolioweb.Repository.EduCRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationService implements IEducationService {

    @Autowired
    EduCRepository eduRepo;
    
    @Override
    public void saveEdu(EduCard newCard) {
        eduRepo.save(newCard);
    }

    @Override
    public List<EduCard> getEdus() {
       List<EduCard> listaTarjetas = eduRepo.findAll();
        return listaTarjetas;
    }

    @Override
    public void deleteEdu(int id) {
        eduRepo.deleteById(id);
    }

    @Override
    public EduCard findEdu(int id) {
        EduCard searchedCard;
        searchedCard = eduRepo.findById(id).orElse(null);
        return searchedCard;
    }

    @Override
    public void updateEdu(EduCard oldCard, String newTitle, String newBody) {
        if (!(newTitle.isEmpty())) {
            oldCard.setTitle(newTitle);
        }
        if (!(newBody.isEmpty())) {
            oldCard.setBody(newBody);
        }
    }
    
}
