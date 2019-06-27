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
	    return sumAll(numbers, number -> true);
	}
	
	public static int sumAllEven(List<Integer> numbers) {
	    return sumAll(numbers, number -> number % 2 == 0);
	}

	public static int sumAllOverThree(List<Integer> numbers) {
	    return sumAll(numbers, number -> number > 3);
	}

	public static int sumAll(List<Integer> numbers, Condition c) {
		Number total = new Number(0);
		numbers.forEach(number -> {
			if (c.test(number)) {
				total.plus(number);
			}
		});

		return total.value();
	}

	static class Number {
		private int number;

		public Number(int number) {
			this.number = number;
		}

		public int plus(int operand) {
			number += operand;

			return number;
		}

		public int value() {
			return number;
		}
	}

	public interface Condition {
		boolean test(Integer number);
	}
}
