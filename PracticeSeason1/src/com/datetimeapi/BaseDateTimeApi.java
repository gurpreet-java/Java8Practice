package com.datetimeapi;

import java.io.PrintStream;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;

/**
 * A. Create and manage date-based and time-based events including a combination of date and time into a single 
  		object using LocalDate, LocalTime, LocalDateTime, Instant, Period, and Duration.
 * @author Gurpreet.Singh
 *
 */
public class BaseDateTimeApi {
	
	private static final PrintStream log = System.out;
	
	private LocalDate getDateAfterTwoDays(LocalDate localDate) {
		return localDate.plusDays(2);
	}
	
	private Period periodBetween() {
		LocalDate startDate = LocalDate.now();
		log.println(startDate);
		LocalDate endDate = LocalDate.now();
		endDate = endDate.plusDays(5); // As immutable.
		log.println(endDate);
		return Period.between(startDate, endDate);
	}
	
	public static void main(String[] args) {
		BaseDateTimeApi baseDateTimeApi = new BaseDateTimeApi();
		// Use of LocalDate.
		log.println(LocalDate.now() + " after 2 days will be " + baseDateTimeApi.getDateAfterTwoDays(LocalDate.now()));
		
		// Use of Instant.
		Instant instant = Instant.ofEpochSecond(LocalDate.now().toEpochDay());
		log.println(instant.getEpochSecond());
		
		// Use of Period.
		Period period = baseDateTimeApi.periodBetween();
		log.println("Period: "+period);
		
		// Use of Duration.
		
	}

}
