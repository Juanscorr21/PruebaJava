package com.prueba.rest;

import java.util.ArrayList;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.model.User;

import com.prueba.service.UserService;
import com.prueba.util.InvalidDataException;

@RestController
@RequestMapping("users")
public class UserRest {
	
	//Instancia del service user, para poder utilizar los servicios que contiene
	@Autowired
	private UserService userService;
	
	//Metodos get, para traer lista de ususarios y buscar por id
	@GetMapping
	public ArrayList<User> getUsers(){
		return userService.listUsers();
	}
	                
	@GetMapping(path = "/{userId}")
	public User getUseById(@PathVariable("userId") Long userId) {
		return userService.findById(userId);
	}
	
	//Metodo post, para crear un usuario
	@PostMapping("/createUser")
	public User createUser(@Valid @RequestBody User user,BindingResult result){
		
		if (result.hasErrors()) {
			throw new InvalidDataException(result);
		}
		return userService.createUser(user);	
	}
	
	//Metodo delete, para eliminar un usuario
	@DeleteMapping(path = "/deleteUser/{userId}")
	public ResponseEntity<User> deleteUser(@PathVariable("userId") Long userId){
		userService.deleteUser(userId);		
		return ResponseEntity.ok(null);
	}
	
	//Metodo put, para actualizar un usuario
	@PutMapping(path = "/updateUser")
	public User updateUser(@Valid  @RequestBody User user,BindingResult result) {	
		
		if (result.hasErrors()) {
			throw new InvalidDataException(result);
		}
		return userService.updateUser(user);
	}
	
}
