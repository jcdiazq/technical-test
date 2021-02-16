package com.wolox.challenge.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="comments")
@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class Comment {
	public Comment() {
	}
	
	@Id
	private int id;
	private int postId;
	private String name;
	private String email;
	@Lob
	private String body;
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}

}