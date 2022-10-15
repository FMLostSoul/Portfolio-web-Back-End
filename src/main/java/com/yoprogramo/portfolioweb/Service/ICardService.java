package com.yoprogramo.portfolioweb.Service;

import com.yoprogramo.portfolioweb.Model.Card;
import java.util.List;

public interface ICardService {

    //Crear o Guardar Tarjetas
    public void saveCard(Card newCard);

    //Listar Tarjetas
    public List<Card> getCards();

    //Eliminar una tarjeta
    public void deleteCard(int id);

    //Buscar una tarjeta
    public Card findCard(int id);

    //Modificar una tarjeta
    public void updateCard(Card oldCard, String newTitle, String newBody);

}
