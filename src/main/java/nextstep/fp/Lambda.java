package nextstep.fp;

import java.util.List;

public class Lambda {
	public static void printAllOld(List<Integer> numbers) {
		System.out.println("printAllOld");
		
		for (int number : numbers) {
		    System.out.println(number);
		}
	}

	public static void printAllLambda(List<Integer> numbers) {
		System.out.println("printAllLambda");
		
		numbers.forEach(System.out::println);
	}
	
	public static void runThread() {
		new Thread(new Runnable() {
		    @Override
		    public void run() {
		        System.out.println("Hello parse thread");
		    }
		}).start();
	}

	public static int sumAll(List<Integer> numbers) {
	    return sumAll(numbers, isAllTrue());
	}
	
	public static int sumAllEven(List<Integer> numbers) {
	    return sumAll(numbers, isAllEven());
	}

	public static int sumAllOverThree(List<Integer> numbers) {
	    return sumAll(numbers, isAllOverThree());
	}
	
	private static Conditional isAllTrue() {
		return number -> true;
	}
	
	private static Conditional isAllEven() {
		return number -> number % 2 == 0;
	}
	
	private static Conditional isAllOverThree() {
		return number -> number > 3;
	}
	
	private static int sumAll(List<Integer> numbers, Conditional c) {
		return numbers.stream()
			.filter(c::test)
			.mapToInt(number -> number)
			.sum();
	}
}
