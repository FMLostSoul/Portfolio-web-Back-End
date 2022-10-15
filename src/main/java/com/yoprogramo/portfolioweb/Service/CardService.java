package com.yoprogramo.portfolioweb.Service;

import com.yoprogramo.portfolioweb.Model.Card;
import com.yoprogramo.portfolioweb.Repository.CardRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService implements ICardService {

    @Autowired
    private CardRepository cardRepository;

    //Crear
    @Override
    public void saveCard(Card newCard) {
        cardRepository.save(newCard);

    }

    //Listar
    @Override
    public List<Card> getCards() {

        List<Card> listaTarjetas = cardRepository.findAll();
        return listaTarjetas;

    }

    //Eliminar
    @Override
    public void deleteCard(int id) {

        cardRepository.deleteById(id);

    }

    //Encontrar
    @Override
    public Card findCard(int id) {

        Card searchedCard;
        searchedCard = cardRepository.findById(id).orElse(null);
        return searchedCard;
    }

    //Actualizar
    @Override
    public void updateCard(Card oldCard, String newTitle, String newBody) {

        if (!(newTitle.isEmpty())) {
            oldCard.setTitle(newTitle);
        }
        if (!(newBody.isEmpty())) {
            oldCard.setBody(newBody);
        }
    }

}
