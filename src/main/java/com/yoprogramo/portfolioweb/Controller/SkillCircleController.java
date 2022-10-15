package com.yoprogramo.portfolioweb.Controller;

import com.yoprogramo.portfolioweb.Model.SkillCircle;
import com.yoprogramo.portfolioweb.Service.ISkillCircleService;
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
public class SkillCircleController {

    @Autowired
    ISkillCircleService circleService;

    @GetMapping("/skill/showall")
    public List<SkillCircle> getCircles() {
        return circleService.getCircles();
    }

    @PostMapping("/skill/create")
    public void createCircle(@RequestBody SkillCircle newCircle) {
        circleService.saveCircle(newCircle);
    }

    @PutMapping("/skill/edit/{id}")
    public void editCircle(@PathVariable int id,
            @RequestBody SkillCircle newCircle) {
        SkillCircle toEdit = circleService.findCircle(id);
        circleService.editCircle(toEdit, newCircle.getPercent(), newCircle.getSkill());
        circleService.saveCircle(toEdit);
    }
    
    @DeleteMapping("/skill/delete/{id}")
    public void deleteCircle(@PathVariable int id){
        circleService.deleteCircle(id);
    }
}
