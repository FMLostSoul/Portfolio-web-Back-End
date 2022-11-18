/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.yoprogramo.portfolioweb.Service;

import com.yoprogramo.portfolioweb.Model.ExpCard;
import java.util.List;

/**
 *
 * @author franc
 */
public interface IExperienceService {
    //Crear
    public void saveExp(ExpCard newCard);

    //Listar
    public List<ExpCard> getExps();

    //Eliminar 
    public void deleteExp(int id);

    //Buscar 
    public ExpCard findExp(int id);

    //Modificar
    public void updateExp(ExpCard oldCard, String newTitle, String newBody);
}
