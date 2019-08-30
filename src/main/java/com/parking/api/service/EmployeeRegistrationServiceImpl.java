package com.parking.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking.api.dto.RegistrationRequestDto;
import com.parking.api.dto.RegistrationResponseDto;
import com.parking.api.entity.Assignation;
import com.parking.api.entity.EmployeeRegistration;
import com.parking.api.entity.Parking;
import com.parking.api.entity.Role;
import com.parking.api.exception.EmailIdInvalidException;
import com.parking.api.repository.AssignationRepository;
import com.parking.api.repository.EmployeeRegistrationRepository;
import com.parking.api.repository.ParkingRepository;
import com.parking.api.repository.RoleRepository;

@Service
public class EmployeeRegistrationServiceImpl implements EmployeeRegistrationService {

	@Autowired
	private EmployeeRegistrationRepository employeeRegistrationRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private AssignationRepository assignationRepository;

	@Autowired
	private ParkingRepository parkingRepository;

	@Override
	public RegistrationResponseDto registration(RegistrationRequestDto registrationRequestDto) {

		EmployeeRegistration employeeRegistration = new EmployeeRegistration();
		Assignation assignation = new Assignation();

		RegistrationResponseDto registrationResponseDto = new RegistrationResponseDto();
		if (isValidEmailAddress(registrationRequestDto.getEmail())) {
			
			employeeRegistration.setEmail(registrationRequestDto.getEmail());
			employeeRegistration.setEmployeeName(registrationRequestDto.getEmployeeName());

			employeeRegistration.setExperience(registrationRequestDto.getExperience());
			employeeRegistration.setTotalExperience(registrationRequestDto.getTotalExperience());
			employeeRegistration.setPassword(registrationRequestDto.getPassword());

			if (registrationRequestDto.getExperience() >= 5 && registrationRequestDto.getTotalExperience() >= 15) {
				Role vipRole = roleRepository.findByRoleName("VIP");
				employeeRegistration.setRoleId(vipRole.getRoleId());

			} else {
				Role regularRole = roleRepository.findByRoleName("REGULAR");
				employeeRegistration.setRoleId(regularRole.getRoleId());
				registrationResponseDto.setMessage("Registration successful");
			}

			EmployeeRegistration saveRegister = employeeRegistrationRepository.save(employeeRegistration);
			if (saveRegister.getRoleId() == 1) {
				assignation.setEmployeeId(saveRegister.getEmployeeId());
				List<Parking> parkingAllot = parkingRepository.findByIsReserved("No");
				for (Parking parking : parkingAllot) {

					Parking parkingLotAvailable = parkingAllot.get(0);
					parkingLotAvailable.setIsReserved("Yes");
					parkingRepository.save(parkingLotAvailable);
					assignation.setParkingId(parkingLotAvailable.getParkingId());
					registrationResponseDto.setMessage("slot booked successfully");
					assignationRepository.save(assignation);

				}

			}

			registrationResponseDto.setStatusCode(201);
			registrationResponseDto.setStatus("Success");
		} else {
			throw new EmailIdInvalidException("email Id is invalid");
		}

		return registrationResponseDto;
	}

	public boolean isValidEmailAddress(String email) {
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
		java.util.regex.Matcher m = p.matcher(email);
		return m.matches();

	}
}