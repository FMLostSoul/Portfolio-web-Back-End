/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.yoprogramo.portfolioweb.Service;

import com.yoprogramo.portfolioweb.Model.EduCard;
import java.util.List;

/**
 *
 * @author franc
 */
public interface IEducationService {
    
    //Crear
    public void saveEdu(EduCard newCard);

    //Listar
    public List<EduCard> getEdus();

    //Eliminar 
    public void deleteEdu(int id);

    //Buscar 
    public EduCard findEdu(int id);

    //Modificar
    public void updateEdu(EduCard oldCard, String newTitle, String newBody);
}
