package com.yoprogramo.portfolioweb.Service;

import com.yoprogramo.portfolioweb.Model.Url;
import com.yoprogramo.portfolioweb.Model.UserProfile;
import java.util.List;

public interface IUserProfileService {

    public void saveInfo(UserProfile userInfo);

    public UserProfile getInfo();

    public void updateInfo(UserProfile userInfo,
            String newUserName,
            String newCareerInfo,
            String newEmail,
            List<Url> newUrls);
}
