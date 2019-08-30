package com.parking.api.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking.api.dto.LoginDto;
import com.parking.api.dto.LoginResponseDto;
import com.parking.api.entity.EmployeeRegistration;
import com.parking.api.entity.Role;
import com.parking.api.exception.InvalidCredentialsException;
import com.parking.api.repository.EmployeeRegistrationRepository;
import com.parking.api.repository.RoleRepository;

@Service
public class LoginServiceImpl implements LoginService {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);
	@Autowired
	private EmployeeRegistrationRepository registrationRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public LoginResponseDto userLogin(LoginDto loginDto) {

		LOGGER.info("inside userLogin method of UserServiceImpl class");
		
		LoginResponseDto loginResponseDto = new LoginResponseDto();
		
		/* get user object based on specific user */
		EmployeeRegistration employee = registrationRepository.findByEmail(loginDto.getEmailId());
		if (employee!=null) {
			if(loginDto.getPassword().equalsIgnoreCase(employee.getPassword())) {
				
				Role role = roleRepository.findByRoleId(employee.getRoleId());
				
				loginResponseDto.setEmployeeId(employee.getEmployeeId());
				loginResponseDto.setRoleName(role.getRoleName());
				loginResponseDto.setEmployeeName(employee.getEmployeeName());
				loginResponseDto.setMessage("User has  been logged in successfully");
				loginResponseDto.setStatusCode(201);
			}else {
				throw new InvalidCredentialsException("User/Password is wrong !!!");
			}
		} else {
			throw new InvalidCredentialsException("Invalid User");
		}

		return loginResponseDto;
	}

}
