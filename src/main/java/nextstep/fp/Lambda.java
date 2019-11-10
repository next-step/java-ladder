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
				System.out.println("Hello from thread");
			}
		}).start();
	}

	public static int sumAll(List<Integer> numbers) {
		int total = 0;
		for (int number : numbers) {
			total += number;
		}
		return total;
	}

	public static int sumAllLambda(List<Integer> numbers) {
		return numbers.stream()
				.filter(number -> satisfy(number, condition -> true))
				.reduce(0, (o1, o2) -> o1 + o2);
	}

	public static int sumAllLambda2(List<Integer> numbers) {
		return numbers.stream()
				.reduce(0, (o1, o2) -> o1 + satisfyNumber(o2, condition -> true));
	}

	public static int sumAllEven(List<Integer> numbers) {
		int total = 0;
		for (int number : numbers) {
			if (number % 2 == 0) {
				total += number;
			}
		}
		return total;
	}

	public static int sumAllEvenLambda(List<Integer> numbers) {
		return numbers.stream()
				.filter(number -> satisfy(number, condition -> (condition % 2 == 0)))
				.reduce(0, (o1, o2) -> o1 + o2);
	}

	public static int sumAllEvenLambda2(List<Integer> numbers) {
		return numbers.stream()
				.reduce(0, (o1, o2) -> o1 + satisfyNumber(o2, condition -> (condition % 2 == 0)));
	}

	public static int sumAllOverThree(List<Integer> numbers) {
		int total = 0;
		for (int number : numbers) {
			if (number > 3) {
				total += number;
			}
		}
		return total;
	}

	public static int sumAllOverThreeLambda(List<Integer> numbers) {
		return numbers.stream()
				.filter(number -> satisfy(number, condition -> (condition > 3)))
				.reduce(0, (o1, o2) -> o1 + o2);
	}

	public static int sumAllOverThreeLambda2(List<Integer> numbers) {
		return numbers.stream()
				.reduce(0, (o1, o2) -> o1 + satisfyNumber(o2, condition -> condition > 3));
	}

	private static boolean satisfy(int number, Conditional conditional) {
		return conditional.satisfy(number);
	}

	private static int satisfyNumber(int number, Conditional conditional) {
		if (conditional.satisfy(number)) {
			return number;
		}
		return 0;
	}

}
