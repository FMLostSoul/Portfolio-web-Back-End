/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yoprogramo.portfolioweb.Controller;

import com.yoprogramo.portfolioweb.Model.EduCard;
import com.yoprogramo.portfolioweb.Model.ExpCard;
import com.yoprogramo.portfolioweb.Service.IEducationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"https://portfolio-angular-80c26.web.app/", "http://localhost:4200/"})
@RestController
public class EduCController {
    @Autowired
    private IEducationService iEduC;

    //Listar
    @GetMapping("/education/showall")
    public List<EduCard> getCards() {
        return iEduC.getEdus();
    }

    @GetMapping("/education/show/{id}")
    public EduCard findCard(@PathVariable int id) {
        return iEduC.findEdu(id);
    }

    @PostMapping("/education/create")
    public void createCard(@RequestBody EduCard newCard) {
        List<EduCard> cards = iEduC.getEdus();
        if (cards.size() < 4) {
            iEduC.saveEdu(newCard);

        }
    }

    @DeleteMapping("/education/delete/{id}")
    public void deleteCard(@PathVariable int id) {
        iEduC.deleteEdu(id);

    }

    @PutMapping("/education/edit/{id}")
    public EduCard editCard(@PathVariable int id,
            @RequestBody ExpCard newCard) {
        
        EduCard toUpdateCard = iEduC.findEdu(id);
        iEduC.updateEdu(toUpdateCard, newCard.getTitle(), newCard.getBody());
        iEduC.saveEdu(toUpdateCard);

        return toUpdateCard;

    }
}
