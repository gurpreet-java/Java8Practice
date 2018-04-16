package com.datetimeapi;

import java.io.PrintStream;
import java.time.LocalDate;
import java.time.Period;

public class BaseDateTimeApi {
	
	private static final PrintStream log = System.out;
	
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
		Period period = baseDateTimeApi.periodBetween();
		log.println("Period: "+period);
	}

}
