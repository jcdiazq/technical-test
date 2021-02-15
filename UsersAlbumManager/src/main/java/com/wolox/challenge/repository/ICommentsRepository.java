package com.wolox.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wolox.challenge.domain.Comment;

@Repository
public interface ICommentsRepository extends CrudRepository<Comment, Integer> {

	@Query("SELECT C FROM Comment C WHERE LOWER(C.name) LIKE LOWER(concat('%', concat(?1, '%')))")
	List<Comment> findByName(String name);

	@Query(nativeQuery=true, value="SELECT C.* FROM Comments C JOIN Posts P ON C.post_Id = P.id WHERE P.user_id = ?1 ")
	List<Comment> findByUserId(int id);
}
