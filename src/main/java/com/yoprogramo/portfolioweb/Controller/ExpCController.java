/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yoprogramo.portfolioweb.Controller;

import com.yoprogramo.portfolioweb.Model.ExpCard;
import com.yoprogramo.portfolioweb.Service.IExperienceService;
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
public class ExpCController {

    @Autowired
    private IExperienceService iExpC;

    //Listar
    @GetMapping("/experience/showall")
    public List<ExpCard> getCards() {
        return iExpC.getExps();
    }

    @GetMapping("/experience/show/{id}")
    public ExpCard findCard(@PathVariable int id) {
        return iExpC.findExp(id);
    }

    @PostMapping("/experience/create")
    public void createCard(@RequestBody ExpCard newCard) {
        List<ExpCard> cards = iExpC.getExps();
        if (cards.size() < 6) {
            iExpC.saveExp(newCard);

        }
    }

    @DeleteMapping("/experience/delete/{id}")
    public void deleteCard(@PathVariable int id) {
        iExpC.deleteExp(id);

    }

    @PutMapping("/experience/edit/{id}")
    public ExpCard editCard(@PathVariable int id,
            @RequestBody ExpCard newCard) {

        ExpCard toUpdateCard = iExpC.findExp(id);
        iExpC.updateExp(toUpdateCard, newCard.getTitle(), newCard.getBody());
        iExpC.saveExp(toUpdateCard);

        return toUpdateCard;

    }
}
