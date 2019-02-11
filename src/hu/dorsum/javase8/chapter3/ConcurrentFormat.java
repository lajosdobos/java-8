package hu.dorsum.javase8.chapter3;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * Java 7 java.util.Date and SimpleDateFormatter aren't thread safe, leading to potential concurrency issues
 * SimpleDateFormat stores intermediate results in instance fields. So if one instance is used by two threads they can mess each other's results.
 * 
 */
public class ConcurrentFormat {

	private static final SimpleDateFormat SIMPLE_DATE_FORMATTER = new SimpleDateFormat("yyyy.MM.dd");
	private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy.MM.dd", Locale.US);
	private static final String TEST_DATE = "2011.01.01";
	
	private static boolean execute = true;

	static void run(boolean isJava8) {
	    ExecutorService executor = Executors.newFixedThreadPool(1);
	    while (execute) {
	        executor.submit(new Runnable() {
	            @Override
	            public void run() {
	            	if(isJava8) {
	            		workConcurrentlyWithDateTimeApi();
	            	} else {
		            	workConcurrentlyWithJavaUtilDate();
	            	}
	            }
	        });
	    }
	}

	private static void workConcurrentlyWithJavaUtilDate() {
	    Date date = null;
	    try {
	    	date = SIMPLE_DATE_FORMATTER.parse(TEST_DATE);
	    } catch (Throwable th) {
	        th.printStackTrace();
	        execute = false;
	    }
	    System.out.println("Parsed date: " + date);
	}	
	
	private static void workConcurrentlyWithDateTimeApi() {
	    LocalDate ld = null;
	    try {
	    	ld = LocalDate.parse(TEST_DATE, DATE_TIME_FORMATTER);
	    } catch (Throwable th) {
	        th.printStackTrace();
	        execute = false;
	    }
	    System.out.println("Parsed LocalDate: " + ld);
	}	
	
}
