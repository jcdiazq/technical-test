package com.wolox.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wolox.challenge.domain.Photo;

@Repository
public interface IPhotosRepository extends CrudRepository<Photo, Integer> {

	@Query(nativeQuery=true, value="SELECT P.* FROM Photos P JOIN Albums A ON A.id = P.album_id WHERE A.user_id = ?1 ")
	List<Photo> findByUserId(int id);
}