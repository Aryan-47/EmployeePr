package com.hexaware.CareerCrafterApplication.service;

import com.hexaware.CareerCrafterApplication.customExceptions.ResourceNotFoundException;
import com.hexaware.CareerCrafterApplication.dto.UserDTO;

public interface IUserService {
	public UserDTO searchUserByID(long id) throws ResourceNotFoundException;
	public void deleteUserById(long id) throws ResourceNotFoundException;
}
