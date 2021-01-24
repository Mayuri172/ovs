package com.cg.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	
	
	Optional<User> findByUserName(String userName);
	//public User findByUserName(String userName);
}
