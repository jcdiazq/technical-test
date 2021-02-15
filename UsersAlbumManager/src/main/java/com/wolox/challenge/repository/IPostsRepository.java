package com.wolox.challenge.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wolox.challenge.domain.Post;

@Repository
public interface IPostsRepository extends CrudRepository<Post, Integer> {

}
