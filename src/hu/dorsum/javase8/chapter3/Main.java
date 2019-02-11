package hu.dorsum.javase8.chapter3;

/*
 * Java Date Time classes are not defined consistently, we have Date Class in both java.util as well as java.sql
 * packages. Again formatting and parsing classes are defined in java.text package.
 * 
 * java.util.Date contains both date and time, whereas java.sql.Date contains only date.
 * 
 * Java 7 java.util.Date and SimpleDateFormatter aren't thread safe, leading to potential concurrency issues
 * 
 * Should have been immutable
 * 
 * Also some classes were quite poor: java.util.Date starts from 1900, months start at 1, days start at 0.
 * 
 * Most methods deprecated in JDK1.1
 * 
 * Uses milliseconds from 1970 representation
 *
 * Advantages of the Date Time API:
 *
 *	Immutability
 *	Utility operations : plus, minus, format, parsing, etc.
 *  Extendable
 *  Clarified methods
 *  Separation of concerns (Date, Time, Datetime, TimeZone, Timestamp, etc)
 */

public class Main {

	public static void main(String[] args) {
		
		//LocalDate examples
		LocalDateExample.run();
		
		//LocalTime examples
//		LocalTimeExample.run();
		
		//LocalDateTimeExamples
//		LocalDateTimeExample.run();
		
		//Instant examples
//		InstantExample.run();
		
		//Example for Concurrency problems while using java.util.date  (true:java8, false: java7)
//		ConcurrentFormat.run(true);
		ConcurrentFormat.run(false);

		//Example for immutability	(true:java8, false: java7)
//		ImmutabilityExample.run(true);
//		ImmutabilityExample.run(false);

		//API Utilities
//		DataAPIUtilities.run();
	
		//Formatting
//		DateParseFormatExample.run();
	
		//Legacy support
//		DateAPILegacySupport.run();
	}

}
