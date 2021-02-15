package com.wolox.challenge.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wolox.challenge.domain.user.User;

@Repository
public interface IGenericRepository<T,I> extends CrudRepository<User, Integer> {

}
