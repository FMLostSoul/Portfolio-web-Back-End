package com.yoprogramo.portfolioweb.Service;

import com.yoprogramo.portfolioweb.Model.SkillCircle;
import com.yoprogramo.portfolioweb.Repository.SkillCircleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillCircleService implements ISkillCircleService {

    @Autowired
    SkillCircleRepository skillCRepository;
    
    @Override
    public void createCircle(SkillCircle circle) {
        skillCRepository.save(circle);
    }

    @Override
    public void deleteCircle(int circleId) {
       skillCRepository.deleteById(circleId);
    }

    @Override
    public List<SkillCircle> getCircles() {
        return skillCRepository.findAll();
    }

    @Override
    public SkillCircle findCircle(int circleId) {
        return skillCRepository.findById(circleId).orElse(null);
    }

    @Override
    public void editCircle(SkillCircle toEdit, int newPercent, String newSkill) {
        if(newPercent >= 0 && newPercent <= 100)
        toEdit.setPercent(newPercent);
        
        if(!newSkill.isEmpty())
        toEdit.setSkill(newSkill);
        
    }
    
}
