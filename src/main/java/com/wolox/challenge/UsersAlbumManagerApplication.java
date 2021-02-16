package com.wolox.challenge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wolox.challenge.logical.IRestExternalRequest;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UsersAlbumManagerApplication {
	
	private static final Logger log = LoggerFactory.getLogger(UsersAlbumManagerApplication.class);
	
	@Autowired
	private IRestExternalRequest restRequest;
		
	public static void main(String[] args) {
		SpringApplication.run(UsersAlbumManagerApplication.class, args);
	}
	
	@Bean
	public void start() {
		try {
			restRequest.invoke();
		} catch (Exception e) {
			log.error(String.format("Se presentó un error en la ejecución. %s", e));
		}
	}
}