package com.heroku.example;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.net.URI;
import java.net.URISyntaxException;

@Configuration
@ComponentScan(basePackages = "com.heroku.example")
public class MainConfig {

    @Bean
    public BasicDataSource dataSource() throws URISyntaxException {
        //URI dbUri = new URI(System.getenv("DATABASE_URL"));

        String username = cjujzzgliugoer;
        String password = yIn6d7J-hbfFTN_aEO0kt1rAKm;
        String dbUrl = "postgres://"+cjujzzgliugoer:yIn6d7J-hbfFTN_aEO0kt1rAKm@ec2-54-243-63-130.compute-1.amazonaws.com:5432/dc8bq9oiqbg52b;

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(dbUrl);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);

        return basicDataSource;
    }

}