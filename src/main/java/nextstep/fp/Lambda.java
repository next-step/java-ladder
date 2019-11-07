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
		int start = 0;
	    return numbers.stream()
				.reduce(start, (sum, b) -> sum += b);
	}

	public static int sumAllEven(List<Integer> numbers) {
	    int start = 0;
		return numbers.stream()
				.filter(number -> number % 2 == 0)
				.reduce(start, (sum, b) -> sum += b);
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
}
