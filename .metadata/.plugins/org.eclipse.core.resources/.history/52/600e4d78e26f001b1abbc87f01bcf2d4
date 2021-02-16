package com.wolox.challenge.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wolox.challenge.domain.user.User;

@Entity(name="albums_permissions")
@Table(uniqueConstraints=@UniqueConstraint(columnNames= {"user_id", "album_id"}))
@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class AlbumPermission {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne(cascade=CascadeType.ALL)
	private User user;
	@ManyToOne(cascade=CascadeType.ALL)
	private Album album;
	private boolean toWrite;
	private boolean hidde;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUserId() {
		return user;
	}
	public void setUserId(User user) {
		this.user = user;
	}
	public Album getAlbumId() {
		return album;
	}
	public void setAlbumId(Album album) {
		this.album = album;
	}
	public boolean isToWrite() {
		return toWrite;
	}
	public void setToWrite(boolean toWrite) {
		this.toWrite = toWrite;
	}
	public boolean isHidde() {
		return hidde;
	}
	public void setHidde(boolean hidde) {
		this.hidde = hidde;
	}
	
}
