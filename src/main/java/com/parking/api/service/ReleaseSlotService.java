package com.parking.api.service;

import com.parking.api.dto.ReleaseSlotRequestDto;
import com.parking.api.dto.ReleaseSlotResponeDto;

public interface ReleaseSlotService {

	public ReleaseSlotResponeDto releaseSlot(ReleaseSlotRequestDto releaseSlotRequestDto);

}
