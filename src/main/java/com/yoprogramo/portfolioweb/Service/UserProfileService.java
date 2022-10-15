package com.yoprogramo.portfolioweb.Service;

import com.yoprogramo.portfolioweb.Model.Url;
import com.yoprogramo.portfolioweb.Model.UserProfile;
import com.yoprogramo.portfolioweb.Repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService implements IUserProfileService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UrlService urlService;

    @Override
    public void saveInfo(UserProfile userInfo) {

        userRepository.save(userInfo);
    }

    @Override
    public UserProfile getInfo() {
        UserProfile profileInfo = userRepository.findById(1).orElse(null);

        return profileInfo;
    }

    @Override
    public void updateInfo(UserProfile userInfo,
            String newUserName,
            String newCareerInfo,
            String newEmail,
            List<Url> newUrls) {
        if (!(newUserName.isEmpty())) {
            userInfo.setUserName(newUserName);
        }
        if (!(newCareerInfo.isEmpty())) {
            userInfo.setCareerInfo(newCareerInfo);
        }
        if (!(newEmail.isEmpty())) {
            userInfo.setEmail(newEmail);
        }

        if (!(newUrls.isEmpty())) {
            userInfo.setUrls(newUrls);
        }

    }
}
