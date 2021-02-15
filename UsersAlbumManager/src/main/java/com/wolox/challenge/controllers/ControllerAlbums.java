package com.wolox.challenge.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.wolox.challenge.domain.Album;
import com.wolox.challenge.exception.ExceptionDataBase;
import com.wolox.challenge.repository.IAlbumsRepository;

@RestController
public class ControllerAlbums {

	private static final Logger log = LoggerFactory.getLogger(ControllerAlbums.class);

	@Autowired
	private IAlbumsRepository repoAlbums;

	@GetMapping("/v1/albums")
	public List<Album> getAllAlbum(){
		try {
			return (List<Album>) repoAlbums.findAll();
		} catch (Exception e) {
			log.error(String.format("Se presentó un error en la consulta. %s", e));
			throw new ExceptionDataBase(String.format("Error Información no Recuperada. %s",e));
		}

	}

	@GetMapping("/v1/albums/userid/{id}")
	public List<Album> getAlbumByUser(@PathVariable final int id){
		try {
			return (List<Album>) repoAlbums.findByUserId(id);
		} catch (Exception e) {
			log.error(String.format("Se presentó un error en la consulta. %s", e));
			throw new ExceptionDataBase(String.format("Error Información no Recuperada. %s",e));
		}

	}
}
