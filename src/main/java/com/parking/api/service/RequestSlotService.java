package com.parking.api.service;

import com.parking.api.dto.BookSlotRequestDto;
import com.parking.api.dto.RequestSlotRequestDTO;
import com.parking.api.dto.RequestSlotResponseDTO;

public interface RequestSlotService {

	RequestSlotResponseDTO requestSlot(RequestSlotRequestDTO requestSlotRequestDTO);

	RequestSlotResponseDTO bookSlot(BookSlotRequestDto bookSlotRequestDto);

}
