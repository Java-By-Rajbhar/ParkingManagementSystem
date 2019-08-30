package com.parking.api.schedul;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.parking.api.service.DailyParkingService;

/**
 * @author Laxman
 * @date 30-08-2019
 */
@Component
public class InsertDailyParking {
	
	@Autowired
	private DailyParkingService dailyParkingService;
	
	/**
	 * desc : it is start the cron job for daily praking alot 
	 */
	@Scheduled(cron = "*/1 * * * * *")
	public void cronJobSch() {
		
		LocalDate localDate = LocalDate.now();
		
		dailyParkingService.dailyParking();

	}
}
