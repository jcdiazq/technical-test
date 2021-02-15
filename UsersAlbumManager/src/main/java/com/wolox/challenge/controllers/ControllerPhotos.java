package com.wolox.challenge.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.wolox.challenge.domain.Photo;
import com.wolox.challenge.exception.ExceptionDataBase;
import com.wolox.challenge.repository.IPhotosRepository;

@RestController
public class ControllerPhotos {

	private static final Logger log = LoggerFactory.getLogger(ControllerPhotos.class);

	@Autowired
	private IPhotosRepository repoPhotos;

	@GetMapping("/v1/photos")
	public List<Photo> getAllPhotos() {
		try {
			return (List<Photo>) repoPhotos.findAll();
		} catch (Exception e) {
			log.error(String.format("Se presentó un error en la consulta. %s", e));
			throw new ExceptionDataBase(String.format("Error Información no Recuperada. %s",e));
		}
	}

	@GetMapping("/v1/photos/userid/{id}")
	public List<Photo> findByUserId(@PathVariable final int id){
		try {
			return (List<Photo>) repoPhotos.findByUserId(id);
		} catch (Exception e) {
			log.error(String.format("Se presentó un error en la consulta. %s", e));
			throw new ExceptionDataBase(String.format("Error Información no Recuperada. %s",e));
		}
	}

}
