package com.yoprogramo.portfolioweb.Controller;

import com.yoprogramo.portfolioweb.Model.Card;
import com.yoprogramo.portfolioweb.Service.ICardService;
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
public class CardController {

    @Autowired
    private ICardService iCard;

    //Listar
    @GetMapping("/card/showall")
    public List<Card> getCards() {
        return iCard.getCards();
    }

    @GetMapping("/card/show/{id}")
    public Card findCard(@PathVariable int id) {
        return iCard.findCard(id);
    }

    @PostMapping("/card/create")
    public void createCard(@RequestBody Card newCard) {
        List<Card> cards = iCard.getCards();
        if (cards.size() < 4) {
            iCard.saveCard(newCard);
        }
    }

    @DeleteMapping("/card/delete/{id}")
    public void deleteCard(@PathVariable int id) {
        iCard.deleteCard(id);

    }

    @PutMapping("/card/edit/{id}")
    public Card editCard(@PathVariable int id,
            @RequestBody Card newCard) {
        Card toUpdateCard = iCard.findCard(id);
        iCard.updateCard(toUpdateCard, newCard.getTitle(), newCard.getBody());
        iCard.saveCard(toUpdateCard);

        return toUpdateCard;

    }

}
