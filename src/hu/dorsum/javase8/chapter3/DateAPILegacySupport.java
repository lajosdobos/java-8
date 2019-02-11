package hu.dorsum.javase8.chapter3;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DateAPILegacySupport {

	static void run() {
		Instant timestamp = new Date().toInstant();
		
		//Now we can convert Instant to LocalDateTime or other similar classes
		LocalDateTime date = LocalDateTime.ofInstant(timestamp, 
						ZoneId.of(ZoneId.SHORT_IDS.get("PST")));
		System.out.println("Date: " + date);
		
		//Calendar to Instant
		Instant time = Calendar.getInstance().toInstant();
		System.out.println("Calendar to instant: " + time);
		
		//TimeZone to ZoneId
		ZoneId defaultZone = TimeZone.getDefault().toZoneId();
		System.out.println("Timezone to ZoneId: " + defaultZone);
		
		//ZonedDateTime from specific Calendar
		ZonedDateTime gregorianCalendarDateTime = new GregorianCalendar().toZonedDateTime();
		System.out.println("ZonedDateTime from Calendar: " + gregorianCalendarDateTime);
		
		//Date API to Legacy classes
		Date dt = Date.from(Instant.now());
		System.out.println("java.util.Date from Instant: " + dt);
		
	}
	
}
