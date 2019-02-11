package hu.dorsum.javase8.chapter3;

import java.time.LocalDate;
import java.time.ZoneId;

public class LocalDateExample {
	
	static void run() {
		LocalDate ld = LocalDate.now();		
		System.out.println("LocalDate without parameters: " + ld);
		
		ld = LocalDate.of(2018, 2, 2);	
		System.out.println("LocalDate with parameters: " + ld);
		
		LocalDate todayKolkata = LocalDate.now(ZoneId.of("Asia/Kolkata"));
		System.out.println("Current Date in IST="+todayKolkata);
		
		//Getting date from the base date i.e 01/01/1970
		LocalDate dateFromBase = LocalDate.ofEpochDay(366);
		System.out.println("365th day from base date= "+dateFromBase);
		
		LocalDate hundredDay2014 = LocalDate.ofYearDay(2014, 100);
		System.out.println("100th day of 2014="+hundredDay2014);
		
	}

}
