package com.prueba.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;


import com.prueba.model.User;
import com.prueba.repository.UserRepository;

@Service
public class UserService {
	
	//instanciamos el repositorio para poder implementar las funciones que nos ofrece Jpa
	@Autowired
	UserRepository userRepository;
	
	//metodo que cumple la funcion de listarme los usuarios
	public ArrayList<User> listUsers(){
		List<User> users = userRepository.findAll();
		
		if (users == null || users.isEmpty() ) {
			throw new  NoSuchElementException( "No hay usuarios");
		}else {
			return (ArrayList<User>) userRepository.findAll();
		}	
	}
	
	//metodo que cumple la funcion de buscar un usuario por id
	public User findById(Long id) {
		Optional<User> optionalUser =  userRepository.findById(id);	
		 
		if (optionalUser.isEmpty()) {
			    throw new NoSuchElementException("No existe usuario con el id: " + id);
			  }
			
		 return optionalUser.get();
			
	}
	
	//metodo que cumple la funcion de crear un usuario
	public User  createUser(User user){
		
		Optional<User> existingUser = userRepository.findByUserName(user.getUserName());
		Optional<User> idUser = userRepository.findById(user.getId());
		
		if(existingUser.isPresent()) {
			
			throw new  DuplicateKeyException( "Ya existe un usuario con este nombre de usuario: " + user.getUserName());
			
		}
		
		if (idUser.isPresent()) {
			throw new  DuplicateKeyException( "Ya existe un usuario con este id: " + user.getId());
			
		}
		
		return userRepository.save(user);
	}
 
	//metodo que cumple la funcion de actualizar un usuario
	public User  updateUser(User user) {
		User saveUser = userRepository.save(user);
		return saveUser;
					
		
	}
	
	public int prueba() {
		return 5;
	}
	
	//metodo que cumple la funcion de eliminar un usuario
	public boolean  deleteUser(Long id){
		try {
			userRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	
	public int sumar(int a, int b) {
		return a + b;
	}
	
}
