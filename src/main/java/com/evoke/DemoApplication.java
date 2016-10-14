package com.evoke;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	private Environment env;
	private String postUrl;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	 @Bean
		public BasicDataSource dataSource() throws URISyntaxException {
		 postUrl = env.getProperty("service.url");
		 System.out.println("service.url value is:::"+postUrl);
		    URI dbUri = new URI(System.getenv("DATABASE_URL"));
		    System.out.println("DATABASE_URL:::::"+ dbUri);
		    String username = dbUri.getUserInfo().split(":")[0];
		    String password = dbUri.getUserInfo().split(":")[1];
		    String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + dbUri.getPath();
		
		    BasicDataSource basicDataSource = new BasicDataSource();
		    basicDataSource.setUrl(dbUrl);
		    basicDataSource.setUsername(username);
		    basicDataSource.setPassword(password);
		
		    return basicDataSource;
		}
}
