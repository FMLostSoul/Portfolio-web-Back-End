package com.yoprogramo.portfolioweb.Service;

import com.yoprogramo.portfolioweb.Model.Url;
import com.yoprogramo.portfolioweb.Repository.UrlRepository;
import com.yoprogramo.portfolioweb.Repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlService implements IUrlService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UrlRepository urlRepository;

    @Override
    public void save(List<Url> urls) {
        List<Url> toEdit = getUrls();
        int i;
        for (i = 0; i < urls.size(); i++) {
            if (!(urls.get(i).getUrl().isEmpty())) {
                Url newUrl = urls.get(i);

                if (i <= toEdit.size()) {
                    toEdit.get(i).setUrl(newUrl.getUrl());
                } else {
                    urlRepository.save(newUrl);
                }
            }
        }
    }

    @Override
    public List<Url> getUrls() {
        List<Url> urlList = urlRepository.findAll();
        return urlList;
    }

    @Override
    public Url getByUrlId(int id) {
        Url url = urlRepository.findById(id).orElse(null);
        return url;
    }

}
