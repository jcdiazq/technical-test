package com.wolox.challenge.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wolox.challenge.domain.user.User;
import com.wolox.challenge.exception.ExceptionDataBase;
import com.wolox.challenge.repository.IUsersRepository;

@RestController
public class ControllerUsers {
	
	private static final Logger log = LoggerFactory.getLogger(ControllerUsers.class);
	
	@Autowired
	private IUsersRepository repoUsers;
	
	@GetMapping("/v1/users")
	public List<User> getAllUser(){
		try {
			return (List<User>) repoUsers.findAll();
		} catch (Exception e) {
			log.error(String.format("Se presentó un error en la consulta. %s", e));
			throw new ExceptionDataBase("Error Información no Recuperada.");
		}
	}

//	for (var obj : object) {
//	ObjectMapper objectMapper = new ObjectMapper();
//	String json = objectMapper.writeValueAsString(obj);
//	log.info(json);		
//}

}
