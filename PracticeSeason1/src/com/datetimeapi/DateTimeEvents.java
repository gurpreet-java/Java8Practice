package com.datetimeapi;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * C. Define and create and manage date-based and time-based events using Instant, Period, Duration
	 	and TemporalUnit.
 * @author Gurpreet.Singh
 *
 */
public class DateTimeEvents {
	
	// Date/time events using Instant
	public Instant getInstant() {
		Instant instant = Instant.now();		
		return instant;
	}
	
	// Date/time events using Period
	public void printNextWeekUsingPeriod() {
		LocalDateTime today = LocalDateTime.now();
		Period period = Period.ofDays(7);
		LocalDateTime nextWeek = today.plus(period);
		System.out.println(today + "  ---   " + nextWeek);
	}
	
	// Date/time events using Duration
	public void printNextHourUsingDuration() {
		LocalDateTime today = LocalDateTime.now();
		Duration duration = Duration.ofHours(1);
		LocalDateTime nextWeek = today.plus(duration);
		System.out.println(today + "  ---   " + nextWeek);
	}
	
	// Date/time events using TemporalUnit
	public void printNextWeekWithHourUsingTemporalUnit() {
		LocalDate date1 = LocalDate.now();
		LocalDate date2 = LocalDate.now().plusYears(3);
		long years = ChronoUnit.YEARS.between(date1, date2);
		System.out.println(years);
	}
	
	/*
	 * Instant/Duration are the implementations of TemporalAmount interface.
	 */
	public static void main(String args[]) {
		DateTimeEvents dateTimeEvents = new DateTimeEvents();
		System.out.println(dateTimeEvents.getInstant());
		dateTimeEvents.printNextWeekUsingPeriod();
		dateTimeEvents.printNextHourUsingDuration();
		dateTimeEvents.printNextWeekWithHourUsingTemporalUnit();
	}
	
}
