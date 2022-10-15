package com.yoprogramo.portfolioweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class PortfoliowebApplication {

    public static void main(String[] args) {
        SpringApplication.run(PortfoliowebApplication.class, args);
    }

}
