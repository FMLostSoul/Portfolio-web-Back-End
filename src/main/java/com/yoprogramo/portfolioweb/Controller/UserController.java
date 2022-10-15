package com.yoprogramo.portfolioweb.Controller;

import com.yoprogramo.portfolioweb.Model.UserProfile;
import com.yoprogramo.portfolioweb.Service.IUrlService;
import com.yoprogramo.portfolioweb.Service.IUserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"https://portfolio-angular-80c26.web.app/", "http://localhost:4200/"})
public class UserController {

    @Autowired
    private IUserProfileService profileService;

    @Autowired
    private IUrlService urlService;
    
    @GetMapping("/home")
    public UserProfile getInfo() {
        return profileService.getInfo();
    }

    @PutMapping("edit/profile/update")
    public void saveProfile(@RequestBody UserProfile newProfile) {

        UserProfile toUpdate = profileService.getInfo();
        profileService.updateInfo(toUpdate, newProfile.getUserName(), newProfile.getCareerInfo(), newProfile.getEmail(), newProfile.getUrls());
        urlService.save(toUpdate.getUrls());
        profileService.saveInfo(toUpdate);

    }

}
