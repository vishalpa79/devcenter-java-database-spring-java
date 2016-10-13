package com.evoke;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	 @Bean
		public BasicDataSource dataSource() throws URISyntaxException {
		    URI dbUri = new URI(System.getenv("DATABASE_URL"));
		
		    String username = dbUri.getUserInfo().split(":")[0];
		    String password = dbUri.getUserInfo().split(":")[1];
		    String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + dbUri.getPath();
		
		    BasicDataSource basicDataSource = new BasicDataSource();
		    basicDataSource.setUrl(dbUrl);
		    basicDataSource.setUsername(username);
		    System.out.println("username::::"+username);
		    basicDataSource.setPassword(password);
		    System.out.println("password::::"+password);
		    return basicDataSource;
		}
}
