package com.wolox.challenge.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wolox.challenge.domain.Album;

@Repository
public interface IAlbumsRepository extends CrudRepository<Album, Integer>{

	List<Album> findByUserId(int id);
}
