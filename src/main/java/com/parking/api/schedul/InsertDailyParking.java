package com.parking.api.schedul;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Laxman
 *
 */
@Component
public class InsertDailyParking {

	@Scheduled(cron = "0 * 9 * * ?")
	public void cronJobSch() {

	}
}
