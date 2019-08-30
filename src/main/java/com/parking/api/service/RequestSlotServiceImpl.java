package com.parking.api.service;

import java.util.List;

import org.apache.commons.httpclient.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.parking.api.dto.BookSlotRequestDto;
import com.parking.api.dto.RequestSlotRequestDTO;
import com.parking.api.dto.RequestSlotResponseDTO;
import com.parking.api.entity.ParkingRequest;
import com.parking.api.exception.RepeatedReadException;
import com.parking.api.repository.ParkingRequestRepository;

@Service

public class RequestSlotServiceImpl implements RequestSlotService {

	private static final Logger LOGGER = LoggerFactory.getLogger(RequestSlotServiceImpl.class);

	@Autowired
	ParkingRequestRepository parkingRequestRepository;

	public RequestSlotResponseDTO requestSlot(RequestSlotRequestDTO requestSlotRequestDTO) {

		LOGGER.info("inside RequestSlotServiceImpl");
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

	@Transactional(isolation = Isolation.REPEATABLE_READ)
	public RequestSlotResponseDTO bookSlot(BookSlotRequestDto bookSlotRequestDto) {
		RequestSlotResponseDTO bookSlot = new RequestSlotResponseDTO();

		List<ParkingRequest> parkingList = parkingRequestRepository
				.findByEmployeeId(bookSlotRequestDto.getEmployeeId());

		if (parkingList.isEmpty()) {

			ParkingRequest parkingRequest = new ParkingRequest();

			BeanUtils.copyProperties(bookSlotRequestDto, parkingRequest);
			parkingRequestRepository.save(parkingRequest);

			bookSlot.setMessage("Booked the slot Successfully");
			bookSlot.setStatusCode(HttpStatus.SC_CREATED);
			bookSlot.setStatus("Success");

		}

		else {

			throw new RepeatedReadException("Slot Already Booked");

		}
		return bookSlot;
	}

}
