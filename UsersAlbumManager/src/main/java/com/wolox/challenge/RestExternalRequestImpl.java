package com.wolox.challenge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wolox.challenge.domain.Album;
import com.wolox.challenge.domain.Photo;
import com.wolox.challenge.domain.Comment;
import com.wolox.challenge.domain.Post;
import com.wolox.challenge.domain.user.User;

@Component
public class RestExternalRequestImpl {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private User[] users;
	@Autowired
	private Album[] albums;
	@Autowired
	private Photo[] photos;
	@Autowired
	private Post[] posts;
	@Autowired
	private Comment[] comments;

	@Value("${rest.external.url}")
	private String URL;

	private static final String pathUser = "/users";
	private static final String pathAlbums = "/albums";
	private static final String pathPhotos = "/photos";
	private static final String pathPosts = "/posts";
	private static final String pathComments = "/comments";

	private static final Logger log = LoggerFactory.getLogger(RestExternalRequestImpl.class);

	public RestExternalRequestImpl() {
		// TODO Auto-generated constructor stub
		log.info("Constructor");
	}

	@Bean
	public void invoke() throws JsonProcessingException {
		getDataAll(users, URL.concat(pathUser));
		getDataAll(albums, URL.concat(pathAlbums));
		getDataAll(photos, URL.concat(pathPhotos));
		getDataAll(posts, URL.concat(pathPosts));
		getDataAll(comments, URL.concat(pathComments));
	}

	public void getDataAll(Object[] object, String url) throws JsonProcessingException {
		ResponseEntity<?> objs = restTemplate.getForEntity(url, object.getClass());
		object =  object.getClass().cast(objs.getBody());
		for (var obj : object) {
			ObjectMapper objectMapper = new ObjectMapper();
			String json = objectMapper.writeValueAsString(obj);
			log.info(json);
		}

		//String out = object instanceof User[] ? "Instancias User":""; 
		//log.info(out);
		log.info(object.getClass().toString());
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
}