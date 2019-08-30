package com.parking.api.service;

import java.util.List;

import org.apache.commons.httpclient.HttpStatus;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.parking.api.dto.BookSlotRequestDto;
import com.parking.api.dto.RequestSlotRequestDTO;
import com.parking.api.dto.RequestSlotResponseDTO;
import com.parking.api.entity.ParkingRequest;
import com.parking.api.repository.ParkingRequestRepository;

@Service

public class RequestSlotServiceImpl implements RequestSlotService {

	@Autowired
	ParkingRequestRepository parkingRequestRepository;

	public RequestSlotResponseDTO requestSlot(RequestSlotRequestDTO requestSlotRequestDTO) {
		RequestSlotResponseDTO requestSlotResponseDTO = new RequestSlotResponseDTO();

		List<ParkingRequest> parkingList = parkingRequestRepository
				.findByEmployeeId(requestSlotRequestDTO.getEmployeeId());

		if (parkingList.isEmpty()) {

			ParkingRequest parkingRequest = new ParkingRequest();

			BeanUtils.copyProperties(requestSlotRequestDTO, parkingRequest);
			parkingRequestRepository.save(parkingRequest);

			requestSlotResponseDTO.setMessage("Request Sent Successfully");
			requestSlotResponseDTO.setStatusCode(HttpStatus.SC_CREATED);
			requestSlotResponseDTO.setStatus("Success");
		}

		else {
			requestSlotResponseDTO.setMessage("Already Requested for a Slot");
			requestSlotResponseDTO.setStatusCode(HttpStatus.SC_CREATED);
			requestSlotResponseDTO.setStatus("Failed");

		}
		return requestSlotResponseDTO;

	}

	@Transactional(isolation = Isolation.READ_COMMITTED)
	public RequestSlotResponseDTO bookSlot(BookSlotRequestDto bookSlotRequestDto) {
		RequestSlotResponseDTO bookSlot = new RequestSlotResponseDTO();

		List<ParkingRequest> parkingList = parkingRequestRepository
				.findByEmployeeId(bookSlotRequestDto.getEmployeeId());

		if (parkingList.isEmpty()) {

			ParkingRequest parkingRequest = new ParkingRequest();

			BeanUtils.copyProperties(bookSlotRequestDto, parkingRequest);
			parkingRequestRepository.save(parkingRequest);

			bookSlot.setMessage("Request Sent Successfully");
			bookSlot.setStatusCode(HttpStatus.SC_CREATED);
			bookSlot.setStatus("Success");
		}

		else {
			bookSlot.setMessage("Already Requested for a Slot");
			bookSlot.setStatusCode(HttpStatus.SC_CREATED);
			bookSlot.setStatus("Failed");

		}
		return bookSlot;
	}

}
