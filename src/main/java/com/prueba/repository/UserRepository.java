package com.prueba.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.prueba.model.User;



@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	
	Optional<User> findByUserName(String userName);

}
