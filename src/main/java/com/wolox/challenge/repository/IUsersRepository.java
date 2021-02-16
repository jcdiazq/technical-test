package com.wolox.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wolox.challenge.domain.user.User;

@Repository
public interface IUsersRepository extends CrudRepository<User, Integer>{
	
	@Query(nativeQuery=true, value="SELECT U.* FROM albums_permissions A JOIN users U ON U.id = A.user_id WHERE album_id = ?1 and to_write = ?2 ")
	List<User> findByAlbumsPermits(int albumId, boolean toWrite);
}
