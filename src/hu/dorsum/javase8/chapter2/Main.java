package hu.dorsum.javase8.chapter2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.DoubleFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
	
	private static List<Person> personList = new ArrayList<>();	
	private static String filterName = "Károly";
	
	private static final Comparator<Person> COMPARE_BY_AGE = (p1, p2) -> p1.getAge() - p2.getAge();
	private static final Consumer<Person> PRINT_PERSON_WITH_BOOKS = p -> System.out.println(p + ", Favourite books: " + p.getBooks());	
	
	private static final Predicate<Person> FILTER_BY_AGE = p -> p.getAge() > 10 && p.getAge() < 20;
	private static final Predicate<Person> FILTER_BY_NAME = p -> p.getFirstName().equals(filterName);
	
	private static final String[] ORAVECZ_BOOKS = {"Az igazi kotelek?","Talald meg magad"};
	private static final String[] COELHO_BOOKS = {"The Alchemist","Veronika Decides to Die "};
	
	static {		
		Set<String> oraveczBooks = new HashSet<>(Arrays.asList(ORAVECZ_BOOKS));
		Set<String> coelhoBooks = new HashSet<>(Arrays.asList(COELHO_BOOKS));
		
		populateList("Fekete","Imre", 20, coelhoBooks);
		populateList("Fekete","Imre", 10, oraveczBooks);
		populateList("Fekete","Benedek", 30, coelhoBooks);
		populateList("Feher","Bab", 12, oraveczBooks);
		populateList("Kovacs","Kristof", 15, coelhoBooks);
		populateList("Jackson","Five", 17, coelhoBooks);
		populateList("Cseh","John", 22, oraveczBooks);
		populateList("Apostol","Pal", 30, oraveczBooks);
		populateList("Kovacs","Totti", 30, oraveczBooks);
		populateList("Horvath","Jonas", 40, oraveczBooks);
	}
	
	private static void populateList(String lastName, String firstName, int age, Set<String> books) {
		personList.add(new Person(firstName, lastName, age, books));
	}	
		
	public static void main(String[] args) throws Exception {					
//		print();				//before sorting
//		compareAndPrint();		//print sorted list
//		filterByAge();			//filter list by age	
//		limit();				//filter with limit
//		minAndMax();			//print oldest and youngest person
//		findAny();				//find specific person in a list
//		collectByFirstName();	//collect by first name after filtering and sorting
//		groupByAge();           //grouping by age
//		flatMap();				//collect all books
//		peek();
//		optionalExample();
		fileStream();	
//		parallelStreamExample();
//		otherExamples();
		
		
	}		
	
	private static void print() {		
		System.out.println("----------------------");
		System.out.println("Person list: ");
		System.out.println("----------------------");

		//Before Java 8 - 1. option
//		for(int i = 0; i < personList.size(); i++) {
//			System.out.println(personList.get(i));
//		}
		
		//Before Java 8 - 2. option
//		for(Person p : personList) {
//			System.out.println(p);
//		}
		
		//Functional Interface - 1
//		personList.forEach(new Consumer<Person>() {
//			@Override
//			public void accept(Person t) {
//				System.out.println(t);
//			}
//		});
//		
		//Functional Interface - 2
//		personList.forEach(new PersonPrinter());
		
		//Lambda expression - 1
//		personList.forEach((Person p) -> System.out.println(p.getFirstName()));

		//Lambda expression - 2
//		personList.forEach(p -> {
//				System.out.println("Person: ");
//				System.out.println(p);				
//			}
//		);
	
		//Method reference
		personList.forEach(System.out::println);
		
	}
	
	private static void compareAndPrint() {
		System.out.println("----------------------");
		System.out.println("Sorted list: ");
		System.out.println("----------------------");

		
		//Before Java 8
		Collections.sort(personList, new Comparator<Person>() { 
			public int compare(Person p1, Person p2) { 
				return p1.getLastName().compareTo(p2.getLastName()); 
			} 
		});		
		
		for(Person p : personList) {
			System.out.println(p);
		}
		
		//Lambda expression - 1
//		personList.sort((p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));		
//		personList.forEach(System.out::println);
		
		//Lambda expression 2)
//		personList.stream()
//			.sorted((p1, p2) -> p1.getLastName().compareTo(p2.getLastName()))
//			.forEach(System.out::println);
		
		//Lambda expression 3)
//		Comparator<Person> compareByName = (p1, p2) -> p1.getLastName().compareTo(p2.getLastName());
//		Consumer<Person> printPerson = p -> System.out.println(p);
////		
//		personList.stream()
//			.sorted(compareByName)
//			.forEach(printPerson);		
		
		personList.stream()
			.sorted(Comparator.comparing(Person::getLastName)
					.thenComparing(Person::getFirstName)
					.reversed()
					.thenComparing(Person::getAge))
			.forEach(System.out::println);		

	}
	
	private static void filterByAge() {
		System.out.println("----------------------");
		System.out.println("People between age 10 and 20: ");
		
		//Before Java 8 - 1
//		for(int i=0; i<personList.size(); i++) {
//			if(personList.get(i).getAge() > 10 && personList.get(i).getAge() < 20) {
//				System.out.println(personList.get(i));
//			}
//		}
		
		//Before Java 8 - 2
//		for(Person p : personList) {
//			if(p.getAge() > 10 && p.getAge() < 20) {
//				System.out.println(p);
//			}
//		}
				
		//Lambda expression
		personList.stream()
			.filter(p -> p.getAge() > 10 && p.getAge() < 20)
			.forEach(System.out::println);
		
	}
	
	private static void limit() {	
		System.out.println("----------------------");
		System.out.println("Three youngest between 10 and 20: ");

		//Before Java 8
//		Collections.sort(personList, new Comparator<Person>() { 
//			public int compare(Person p1, Person p2) { 
//				return p1.getAge() - p2.getAge(); 
//			} 
//		});	
//		
//		int counter = 0;
//		for(Person p : personList) {
//			if(p.getAge() > 10 && p.getAge() < 20) {
//				System.out.println(p);
//				counter++;
//				if(counter == 3) break;
//			}
//		}		

		personList.stream()
			.sorted(COMPARE_BY_AGE)
			.filter(FILTER_BY_AGE)
			.limit(3)
			.forEach(System.out::println);
				
	}
	
	private static void minAndMax() {
		System.out.println("----------------------");
		System.out.println("Oldest person: ");
		
		//Before Java 8- What's the problem with this one?
		Person oldest = personList.get(0);				
		for(Person p : personList) {
			if(p.getAge() > oldest.getAge()) {
				oldest = p;
			}
		}
		System.out.println("Oldest person: " + oldest);
//		
		//Lambda expression 1 - Oldest
//		Person person = personList.stream()
//			.max(COMPARE_BY_AGE)
//			.get();
//		System.out.println(person);
		
		//Lambda expression - 2 - Youngest person	
//		System.out.println("----------------------");
//		System.out.println("Youngest person: ");
//		
//		personList.stream()
//				.min(COMPARE_BY_AGE)
//				.ifPresent(System.out::println);		
		
		//Lambda expression - 2
		Person opt = personList.stream()
				.min(COMPARE_BY_AGE)
//				.orElseThrow(IllegalArgumentException::new);
				.orElseGet(Person::new);
		System.out.println(opt);

	}
	
	private static void findAny() throws Exception {
		System.out.println("----------------------");
		System.out.println("Find person's first name as string example: ");
		System.out.println("----------------------");

		//Before Java 8
		String res = null;
		
		for(Person p : personList) {
			if(p.getFirstName().equals(filterName)) {
				res = p.getFirstName();
			}
		}
		
		if(res == null) {
			System.out.println("There's no " + filterName);
		} else {
			System.out.println(res);
		}		
		
//		//Lambda expression
		filterName = "Imre234";
		String result = personList.stream()
			.filter(p -> p.getFirstName().equals(filterName))
			.map(Person::toString)
			.findAny()
			.orElse("There's no " + filterName);
			//.orElseThrow(Exception::new);
			System.out.println(result);
		

	}
	
	private static void collectByFirstName() {
		System.out.println("---------------------------------------------");
		System.out.println("Firstnames after filtering and sorting: ");
		System.out.println("---------------------------------------------");

		//Before Java 8	
		List<Person> tmpList = new ArrayList<>();
		for(Person p : personList) {
			if(p.getAge() > 10 && p.getAge() < 20) {
				tmpList.add(p);
			}
		}
		
		Collections.sort(tmpList, new Comparator<Person>() { 
			public int compare(Person p1, Person p2) { 
				return p1.getAge() - p2.getAge(); 
			} 
		});	
		
		for(Person p : tmpList) {
			System.out.println(p.getFirstName());
		}
		
		//Lambda expression
		List<String> names = personList.stream()
			.filter(FILTER_BY_AGE)
			.sorted(COMPARE_BY_AGE)
			.map(Person::getFirstName)		//.map(p -> p.getFirstName())
			.collect(Collectors.toList());
		
		names.forEach(System.out::println);
	}
	
	private static void groupByAge() {
		System.out.println("----------------------");
		System.out.println("Grouping by age: ");
		
		//Before Java 8
//		Map<Integer, List<String>> resMap = new HashMap<>();
//		for(Person p : personList) {
//			if(!resMap.containsKey(p.getAge())) {
//				List<String> tmpList = new ArrayList<>();
//				tmpList.add(p.getFirstName());
//				resMap.put(p.getAge(), tmpList);
//			} else {
//				resMap.get(p.getAge()).add(p.getFirstName());
//			}
//		}
//		System.out.println(resMap);		
		
		//Lambda expression - 1
//		Map<Integer, List<Person> > res =
//					personList.stream()
//							  .collect(Collectors.groupingBy(Person::getAge));
//		System.out.println(res);

		//Lambda expression - 2
		Map<Integer, List<String>> res2 = personList.stream()
                	.collect(Collectors.groupingBy(Person::getAge,
                			Collectors.mapping(Person::getFirstName, Collectors.toList())));
		System.out.println(res2);
		
//		
//		personList.stream()
//    		.collect(Collectors.groupingBy(Person::getAge,
//    			Collectors.mapping(Person::getFirstName, Collectors.toList())))
//			.entrySet()
//			.stream()
//    		.sorted((e1,e2)-> e1.getKey() - e2.getKey())
//			.forEach(System.out::println);
		
	}
	
	private static void flatMap() {
		System.out.println("----------------------");
		System.out.println("Complete list of books: ");
		
		//Before Java 8
//		List<String> bookNames = new ArrayList<>();
//		for(Person p : personList) {
//			for(String s : p.getBooks()) {
//				if(!bookNames.contains(s)) {
//					bookNames.add(s);
//				}
//			}
//		}
//		
//		for(String s : bookNames) {
//			System.out.println(s);
//		}
		
		//Lambda expression - flatmap
		List<String> books = personList.stream() 	
				.map(Person::getBooks)
				.flatMap(Set::stream)
				.distinct()
				.collect(Collectors.toList());
		books.forEach(System.out::println);
		
	}

	private static void peek() {
		double sum = personList.parallelStream()
				.filter(p -> p.getAge() > 12)
				.filter(p -> p.getAge() < 30)
				.peek(p -> p.setAge(30))
				.mapToDouble(p -> p.getAge())
				.sum();
		System.out.println("sum: " + sum);
	}
	
	/*
	 * It is used to represent a value is present or absent.
	 * Advantages of Java 8 Optional:
			Null checks are not required.
			No more NullPointerException at run-time.
			We can develop clean and neat APIs.
			No more Boiler plate code			
	 */
	private static void optionalExample() {
		System.out.println("----------------------");
		System.out.println("Optional Example: ");			
		
		filterName = "Imr234e";
		Person person = personList.stream()
				.filter(FILTER_BY_NAME)
				.findAny()
				.orElse(null);
		
		Optional<Person> optPerson = Optional.ofNullable(person);			//ofNullable returns empty if not present:
		System.out.println(optPerson.orElseGet(() -> new Person("New", "Person", 20, new HashSet<>(Arrays.asList(ORAVECZ_BOOKS)))));
	}	
	
	private static void fileStream() {
		System.out.println("----------------------");
		System.out.println("File stream example: ");		
		
		
		Stream<String> stream = null;
		String filePath = System.getProperty("user.dir") + File.separator + "resources" + File.separator + "test.txt";
		
		try {
			
			//Lambda expression 1 
			stream = Files.lines(Paths.get(filePath));
			stream.forEach(System.out::println);
					
			//Lambda expression 2 			
//			Predicate<String> filterLines = s -> s.length() - s.replace(",", "").length() >= 2;
//			Function<String, Person> personMapper = p -> {
//				String[] tmp = p.split(",");
//				String firstName = tmp[0].split(" ")[0];
//				String lastName = tmp[0].split(" ")[1];
//				Integer age = Integer.parseInt(tmp[1].trim());
//				
//				Set<String> books = new HashSet<>();
//				for(int i=2; i<tmp.length;i++){
//					books.add(tmp[i]);
//				}
//				
//				return new Person(firstName, lastName, age, books);
//			};
//			
//			stream = Files.lines(Paths.get(filePath));		
//			Stream<Person> validLines = stream
//					.filter(filterLines)
//					.map(personMapper);
//				
//			Stream.concat(personList.stream(), validLines)
//					.distinct()
//					.collect(Collectors.toList())
//					.forEach(PRINT_PERSON_WITH_BOOKS);				
			
			//Lambda 3
			Predicate<String> filterLines = s -> s.length() - s.replace(",", "").length() >= 2;					
			Stream.concat(personList.stream(), Files.lines(Paths.get(filePath))
						.filter(filterLines)
						.map(new PersonMapperFunction())
						.filter(Objects::nonNull))
						.collect(Collectors.toList())
						.forEach(PRINT_PERSON_WITH_BOOKS);
			
			//Before Java 8
//			File file = new File(filePath);
//			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
//			
//			String line = null;
//			List<Person> newPersons = new ArrayList<>();
//			while ((line = br.readLine()) != null) {
//				if(line.length() - line.replace(",", "").length() >= 2) {
//					try {
//						String[] tmp = line.split(",");
//						String lastName = tmp[0].split(" ")[0];
//						String firstName = tmp[0].split(" ")[1];
//						Integer age = Integer.parseInt(tmp[1].trim());			
//						Set<String> books = new HashSet<>();
//						for(int i=2; i<tmp.length;i++){
//							books.add(tmp[i]);
//						}						
//						newPersons.add(new Person(lastName, firstName, age, books));						
//					} catch(ArrayIndexOutOfBoundsException | NumberFormatException e) {
//						System.err.println("Hiba: " + e);
//					}
//				}
//			}
//			br.close();
//			
//			List<Person> result = new ArrayList<>(personList);
//			result.addAll(newPersons);
//			result.forEach(PRINT_PERSON_WITH_BOOKS);			
			
		} catch(IOException e) {
			System.err.println(e);
		} finally {
			if(stream != null) {
				stream.close();
			}
		}
	}
	
	private static void parallelStreamExample() {
		
		int max = 2000000;
		List<String> values = new ArrayList<>(max);
		for (int i = 0; i < max; i++) {
		    UUID uuid = UUID.randomUUID();
		    values.add(uuid.toString());
		}
		
		//Sequential sort example
		long startTime = System.nanoTime();
		long count = values.stream()
				.sorted()
				.count();
		
		values.stream().forEach(u -> {
			UUID uuid = UUID.randomUUID();
			u = uuid.toString();
		});
		
		long endTime = System.nanoTime();
		long millis = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
		System.out.println(endTime);
		System.out.println(startTime);
		System.out.println(String.format("Sequential sort took: %d ms", millis));
		
		startTime = System.nanoTime();
		//Parallel sort example
		count = values.parallelStream()
				.sorted()
				.count();
		
//		values.parallelStream().forEach(u -> {
//			UUID uuid = UUID.randomUUID();
//			u = uuid.toString();
//		});		
		
		endTime = System.nanoTime();
		millis = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
		System.out.println(String.format("Parallel sort took: %d ms", millis));
		
	}
	
	private static void otherExamples() throws Exception {
		//Process Primitive types
		DoubleFunction<String> calc = t -> String.valueOf(t * 3);
		System.out.println(calc.apply(10));
		
		 //If you need to pass in something and return the same type, 
		//use the UnaryOperator interface.
		UnaryOperator<String> unaryString = s -> s.toUpperCase();
		System.out.println(unaryString.apply("bkv"));
		
		//BiPredicate
//		BiPredicate<Person, Boolean> biPred = (p, s) ->
//			p.getAge() == 10;
//		System.out.println(biPred.test(personList.get(0), true));
		
		//peek
//		Stream.of("one", "two", "three", "four")
//        .filter(e -> e.length() > 3)
//        .peek(e -> System.out.println("Filtered value: " + e))
//        .map(String::toUpperCase)
//        .peek(e -> System.out.println("Mapped value: " + e))
//        .collect(Collectors.toList());
				
		//allMatch, nonematch, anyMatch
//		boolean result = personList.stream()
//			.allMatch(p -> p.getAge() > 10);
//		System.out.println("Is everyone older than 10: " + result);
		
		//findFirst, findany
//		Person person = personList.stream()
//				.filter(FILTER_BY_AGE)
//				.findFirst()
//				.orElseThrow(Exception::new);
//		System.out.println(person);
		
		//ArrayList enhanchements		
//		boolean removeIf(predicate)
		personList.removeIf(p -> p.getAge() == 10);

		//void replaceAll(UnaryOperator)
//		personList.replaceAll(p -> personList.get(0));
//		System.out.println(personList);
		
		//Map enhancements
		//computeIfAbsent, computeIsPresent
		Map<String, Boolean> whoLetTheDogsOut = new HashMap<>();
//		whoLetTheDogsOut.computeIfAbsent("woop", k -> f(k));
//		whoLetTheDogsOut.computeIfAbsent("woop", k -> f(k));
//		
//	    //Map stream
	    whoLetTheDogsOut.entrySet().stream().forEach(System.out::println);
	    whoLetTheDogsOut.values().stream().forEach(System.out::println);
	    whoLetTheDogsOut.keySet().stream().forEach(System.out::println);

	    //Stream of
	    Stream.of("Monday", "Tuesday","Wedensday", "Thursday")
	    	.filter(s -> s.startsWith("T"))
	    	.forEach(System.out::println);
	    
	}	
	
	static boolean f(String s) {
        System.out.println("creating a value for \""+s+'"');
        return s.isEmpty();
    }
		
}
