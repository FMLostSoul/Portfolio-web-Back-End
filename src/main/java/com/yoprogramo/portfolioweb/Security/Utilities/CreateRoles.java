package com.yoprogramo.portfolioweb.Security.Utilities;

import com.yoprogramo.portfolioweb.Service.IUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CreateRoles implements CommandLineRunner {

    @Autowired
    IUrlService urlService;

    @Override
    public void run(String... args) throws Exception {
     /**
        Url url1 = new Url("a");
        Url url2 = new Url("b");
        Set<Url> urls = new HashSet<>();
        urls.add(url1);
        urls.add(url2);
        urlService.save(urls);
        
     **/
    }
}

