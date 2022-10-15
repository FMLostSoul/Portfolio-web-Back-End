package com.yoprogramo.portfolioweb.Service;

import com.yoprogramo.portfolioweb.Model.ProjectCard;
import com.yoprogramo.portfolioweb.Repository.ProjectCRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectCService implements IProjectCService {

    @Autowired
    private ProjectCRepository pCardRepository;

    //Crear
    @Override
    public void saveCard(ProjectCard newCard) {
        pCardRepository.save(newCard);

    }

    //Listar
    @Override
    public List<ProjectCard> getCards() {

        List<ProjectCard> listaTarjetas = pCardRepository.findAll();
        return listaTarjetas;

    }

    //Eliminar
    @Override
    public void deleteCard(int id) {

        pCardRepository.deleteById(id);

    }

    //Encontrar
    @Override
    public ProjectCard findCard(int id) {

        ProjectCard searchedCard;
        searchedCard = pCardRepository.findById(id).orElse(null);
        return searchedCard;
    }

    //Actualizar
    @Override
    public void updateCard(ProjectCard oldCard, String newTitle, String newBody) {

        if (!(newTitle.isEmpty())) {
            oldCard.setTitle(newTitle);
        }
        if (!(newBody.isEmpty())) {
            oldCard.setBody(newBody);
        }
    }
}
