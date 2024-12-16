package com.hexaware.CareerCrafterApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.CareerCrafterApplication.customExceptions.ResourceNotFoundException;
import com.hexaware.CareerCrafterApplication.dto.UserDTO;
import com.hexaware.CareerCrafterApplication.service.UserServiceImpl;

@RestController
@RequestMapping("/UserAPI/")
public class UserController {
	private UserServiceImpl userServiceImpl;
//	@Autowired
	public UserController(UserServiceImpl userServiceImpl) {
		super();
		this.userServiceImpl = userServiceImpl;
	}
	
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@GetMapping("/getUserByID/{id}")
	public ResponseEntity<UserDTO> searchUserByID(@PathVariable("id") long id) throws ResourceNotFoundException{
		return ResponseEntity.ok(this.userServiceImpl.searchUserByID(id));
	}
	
	@DeleteMapping("/deleteUserByID/{id}")
	ResponseEntity<String> deleteUserByID(@PathVariable("id") long id) throws ResourceNotFoundException{
		this.userServiceImpl.deleteUserById(id);
		return ResponseEntity.ok("User Deleted with id: "+id);
	}
}
