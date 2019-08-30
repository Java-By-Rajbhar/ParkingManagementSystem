package com.parking.api.service;

import com.parking.api.dto.LoginDto;
import com.parking.api.dto.LoginResponseDto;

public interface LoginService {

	LoginResponseDto userLogin(LoginDto loginDto);

}
