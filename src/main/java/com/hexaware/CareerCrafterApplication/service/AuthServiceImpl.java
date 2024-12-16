package com.hexaware.CareerCrafterApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hexaware.CareerCrafterApplication.customExceptions.UsernameAlreadyExistsException;
import com.hexaware.CareerCrafterApplication.dto.EmployerRegisterDTO;
import com.hexaware.CareerCrafterApplication.dto.JWTAuthResponse;
import com.hexaware.CareerCrafterApplication.dto.JobSeekerRegisterDTO;
import com.hexaware.CareerCrafterApplication.dto.LoginDTO;
import com.hexaware.CareerCrafterApplication.dto.UserDTO;
import com.hexaware.CareerCrafterApplication.models.EmployerProfile;
import com.hexaware.CareerCrafterApplication.models.JobSeekerProfile;
import com.hexaware.CareerCrafterApplication.models.User;
import com.hexaware.CareerCrafterApplication.repository.CompanyRepository;
import com.hexaware.CareerCrafterApplication.repository.EmployerProfileRepository;
import com.hexaware.CareerCrafterApplication.repository.JobSeekerProfileRepository;
import com.hexaware.CareerCrafterApplication.repository.UserRepository;
import com.hexaware.CareerCrafterApplication.security.JwtTokenProvider;

@Service
public class AuthServiceImpl implements IAuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JobSeekerProfileRepository jobSeekerProfileRepository;

    @Autowired
    private EmployerProfileRepository employerProfileRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Override
    public JWTAuthResponse login(LoginDTO dto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenProvider.generateToken(authentication);

        User user = userRepository.findByUsername(dto.getUsername());

        UserDTO userDTO = new UserDTO(user.getUsername(), user.getRole().name());

        return new JWTAuthResponse(token, userDTO);
    }

    @Override
    public String registerJobSeeker(JobSeekerRegisterDTO dto) throws UsernameAlreadyExistsException {
        // Check if username or email already exists
        if (userRepository.existsByUsername(dto.getUsername())) {
            throw new UsernameAlreadyExistsException(dto.getUsername());
        }

        // Create new User
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRole(User.Role.JOB_SEEKER); // Set role for JobSeeker
        userRepository.save(user);

        // Create and save JobSeekerProfile
        JobSeekerProfile profile = new JobSeekerProfile();
        profile.setUsername(dto.getUsername());
        profile.setFirstName(dto.getFirstName());
        profile.setEmail(dto.getEmail());
        profile.setLastName(dto.getLastName());
        profile.setPhoneNumber(dto.getPhoneNumber());
        jobSeekerProfileRepository.save(profile);

        return "Job Seeker registered successfully";
    }

    @Override
    public String registerEmployer(EmployerRegisterDTO dto) throws UsernameAlreadyExistsException{
        // Check if username or email already exists
        if (userRepository.existsByUsername(dto.getUsername())) {
            throw new UsernameAlreadyExistsException(dto.getUsername());
        }

        // Create new User
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRole(User.Role.EMPLOYER); // Set role for Employer
        userRepository.save(user);

        // Create and save EmployerProfile
        EmployerProfile profile = new EmployerProfile();
        profile.setUsername(dto.getUsername());
        profile.setEmail(dto.getEmail());
        employerProfileRepository.save(profile);

        return "Employer registered successfully";
    }
}
