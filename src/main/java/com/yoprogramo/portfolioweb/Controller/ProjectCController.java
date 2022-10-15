package com.yoprogramo.portfolioweb.Controller;

import com.yoprogramo.portfolioweb.Model.ProjectCard;
import com.yoprogramo.portfolioweb.Service.IProjectCService;
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
public class ProjectCController {

    @Autowired
    private IProjectCService iPCard;

    //Listar
    @GetMapping("/project/showall")
    public List<ProjectCard> getCards() {
        return iPCard.getCards();
    }

    @GetMapping("/project/show/{id}")
    public ProjectCard findCard(@PathVariable int id) {
        return iPCard.findCard(id);
    }

    @PostMapping("/project/create")
    public void createCard(@RequestBody ProjectCard newCard) {
        List<ProjectCard> cards = iPCard.getCards();
        if (cards.size() < 4) {
            iPCard.saveCard(newCard);

        }
    }

    @DeleteMapping("/project/delete/{id}")
    public void deleteCard(@PathVariable int id) {
        iPCard.deleteCard(id);

    }

    @PutMapping("/project/edit/{id}")
    public ProjectCard editCard(@PathVariable int id,
            @RequestBody ProjectCard newCard) {
        
        ProjectCard toUpdateCard = iPCard.findCard(id);
        iPCard.updateCard(toUpdateCard, newCard.getTitle(), newCard.getBody());
        iPCard.saveCard(toUpdateCard);

        return toUpdateCard;

    }
}
