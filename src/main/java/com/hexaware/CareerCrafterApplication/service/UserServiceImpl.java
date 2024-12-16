package com.hexaware.CareerCrafterApplication.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.CareerCrafterApplication.customExceptions.ResourceNotFoundException;
import com.hexaware.CareerCrafterApplication.dto.UserDTO;
import com.hexaware.CareerCrafterApplication.models.User;
import com.hexaware.CareerCrafterApplication.repository.UserRepository;


@Service
public class UserServiceImpl implements IUserService {
	private UserRepository userRepo;
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}
	
	@Override
	public UserDTO searchUserByID(long id) throws ResourceNotFoundException {
		User foundUser = this.userRepo.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("User", "id", id)
				);
		UserDTO u2 = mapper.map(foundUser, UserDTO.class);
		return u2;
	}
	
	@Override
	public void deleteUserById(long id) throws ResourceNotFoundException {
	    User existingUser = this.userRepo.findById(id).orElseThrow(
	            () -> new ResourceNotFoundException("User", "id", id)
	    );

	    this.userRepo.delete(existingUser);
	}

}
