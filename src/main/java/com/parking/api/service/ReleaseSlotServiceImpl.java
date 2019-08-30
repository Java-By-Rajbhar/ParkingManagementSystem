package com.parking.api.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.parking.api.dto.ReleaseSlotRequestDto;
import com.parking.api.dto.ReleaseSlotResponeDto;
import com.parking.api.entity.ReleaseSlot;
import com.parking.api.repository.ReleaseRepository;

public class ReleaseSlotServiceImpl implements ReleaseSlotService {
	
	@Autowired
	private ReleaseRepository releaseRepository;

	@Override
	public ReleaseSlotResponeDto releaseSlot(ReleaseSlotRequestDto releaseSlotRequestDto) {

		ReleaseSlotResponeDto releaseSlotResponeDto=new ReleaseSlotResponeDto();
		
		ReleaseSlot release =new ReleaseSlot();
		release.setEmployeeId(releaseSlotRequestDto.getEmployeeId());
		release.setFromDate(releaseSlotRequestDto.getFromDate());
		release.setToDate(releaseSlotRequestDto.getToDate());
		
		releaseSlotResponeDto.setMessage("slot released");
		releaseSlotResponeDto.setStatusCode(201);
		releaseSlotResponeDto.setStatus("Success");
		
		return null;
	}

}
