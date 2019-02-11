package hu.dorsum.javase8.chapter3;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

/*
 * Instant class is used to work with machine readable time format, it stores date time in unix timestamp. 
 */

public class InstantExample {

	static void run() {		
		Instant timestamp = Instant.now();
		System.out.println("Current Timestamp: " + timestamp);
		
		//Instant from timestamp
		Instant specificTime = Instant.ofEpochMilli(timestamp.toEpochMilli());
		System.out.println("Specific Time: " + specificTime);
		
		//Duration example
		LocalDateTime ld = LocalDateTime.of(2018, 01, 12, 10, 10, 10);
		LocalDateTime ld2 = LocalDateTime.of(2010, 01, 12, 10, 10, 10);
		Duration d = Duration.between(ld2, ld);
		System.out.println(d.getSeconds());
		
		LocalDate ldate = LocalDate.of(2014, 3, 12);
		LocalDate ldate2 = LocalDate.now();
		long l = Duration.between(ldate.atStartOfDay(), ldate2.atStartOfDay()).toNanos();
		System.out.println(l);
		
	}
}
