package com.wolox.challenge.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wolox.challenge.domain.Album;

@Repository
public interface IAlbumsRepository extends CrudRepository<Album, Integer>{

}
