package com.hexaware.CareerCrafterApplication.service;

import com.hexaware.CareerCrafterApplication.customExceptions.UsernameAlreadyExistsException;
import com.hexaware.CareerCrafterApplication.dto.EmployerRegisterDTO;
import com.hexaware.CareerCrafterApplication.dto.JWTAuthResponse;
import com.hexaware.CareerCrafterApplication.dto.JobSeekerRegisterDTO;
import com.hexaware.CareerCrafterApplication.dto.LoginDTO;

public interface IAuthService {

	public JWTAuthResponse login(LoginDTO dto);

	public String registerJobSeeker(JobSeekerRegisterDTO dto) throws UsernameAlreadyExistsException;

	public String registerEmployer(EmployerRegisterDTO dto) throws UsernameAlreadyExistsException;

}
