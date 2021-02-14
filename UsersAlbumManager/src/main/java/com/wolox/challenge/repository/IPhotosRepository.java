package com.wolox.challenge.repository;

import org.springframework.data.repository.CrudRepository;

import com.wolox.challenge.domain.Photo;

public interface IPhotosRepository<T,I> extends CrudRepository<Photo, Integer> {

}
