/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.yoprogramo.portfolioweb.Service;

import com.yoprogramo.portfolioweb.Model.SkillCircle;
import java.util.List;


public interface ISkillCircleService {
    
    public void saveCircle(SkillCircle circle);
    
    public void deleteCircle(int circleId);
    
    public List<SkillCircle> getCircles();
    
    public SkillCircle findCircle(int circleId);
    
    public void editCircle(SkillCircle toEdit, int newPercent, String newSkill);
}
