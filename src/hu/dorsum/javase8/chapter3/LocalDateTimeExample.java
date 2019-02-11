package hu.dorsum.javase8.chapter3;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;

/*
 *	Examples: 
 * 		Try creating datetime by providing invalid parameters	
 * 		Try creating datetime by providing invalid timezone parameter
 * 
 */

public class LocalDateTimeExample {

	static void run() {
		
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println("Current DateTime: " + ldt);
		
		ldt = LocalDateTime.of(LocalDate.now(), LocalTime.now());
		System.out.println("Current DateTime: " + ldt);
		
		ldt = LocalDateTime.of(2014, Month.JANUARY, 1, 10, 10, 30);
		System.out.println("DateTime by providing arguments: " + ldt);
		
		//Current date in "Asia/Kolkata", you can get it from ZoneId javadoc
		LocalDateTime todayKolkata = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));
		System.out.println("Current Date in IST: " + todayKolkata);
	
		//Getting date from the base date i.e 01/01/1970
		LocalDateTime dateFromBase = LocalDateTime.ofEpochSecond(10000, 0, ZoneOffset.UTC);
		System.out.println("10000th second time from 01/01/1970= "+dateFromBase);

	}

}
