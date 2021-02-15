package com.wolox.challenge.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wolox.challenge.domain.Photo;

@Repository
public interface IPhotosRepository extends CrudRepository<Photo, Integer> {

}
