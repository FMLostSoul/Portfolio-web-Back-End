package com.yoprogramo.portfolioweb.Service;

import com.yoprogramo.portfolioweb.Model.ProjectCard;
import java.util.List;

public interface IProjectCService {

    //Crear o Guardar Tarjetas
    public void saveCard(ProjectCard newCard);

    //Listar Tarjetas
    public List<ProjectCard> getCards();

    //Eliminar una tarjeta
    public void deleteCard(int id);

    //Buscar una tarjeta
    public ProjectCard findCard(int id);

    //Modificar una tarjeta
    public void updateCard(ProjectCard oldCard, String newTitle, String newBody);

}
