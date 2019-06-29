package nextstep.fp;

import java.util.List;
import java.util.function.IntPredicate;

public class Lambda {
	public static void printAllOld(List<Integer> numbers) {
		System.out.println("printAllOld");
		numbers.forEach(System.out::println);
	}

	public static void printAllLambda(List<Integer> numbers) {
		System.out.println("printAllLambda");
		
		numbers.forEach(System.out::println);
	}
	
	public static void runThread() {
		new Thread(() -> System.out.println("Hello from thread"))
				.start();
	}

	public static int sumAll(List<Integer> numbers) {
		return sumAll(numbers, number -> true);
	}
	
	public static int sumAllEven(List<Integer> numbers) {
		return sumAll(numbers, number -> number % 2 == 0);
	}

	public static int sumAllOverThree(List<Integer> numbers) {
		return sumAll(numbers, number -> number > 3);
	}

	private static int sumAll(List<Integer> numbers, IntPredicate predicate) {
		return numbers
				.stream()
				.mapToInt(Integer::intValue)
				.filter(predicate)
				.sum();
	}
}
