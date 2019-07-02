package nextstep.fp;

import java.util.List;
import java.util.function.Consumer;

public class Lambda {
	public static void printAllOld(List<Integer> numbers) {
		System.out.println("printAllOld");
		
		for (int number : numbers) {
		    System.out.println(number);
		}
	}

	public static void printAllwithoutLambda(List<Integer> numbers) {
		System.out.println("printAllwithoutLambda");

		numbers.forEach(new Consumer<Integer>() {
			@Override
			public void accept(Integer value) {
				System.out.println(value);
			}
		});
	}

	public static void printAllLambda(List<Integer> numbers) {
		System.out.println("printAllLambda");

		numbers.forEach((Integer value) -> System.out.println(value));
		numbers.forEach(value -> System.out.println(value)); // Type 추론 가능해 Type 생략 가능
		numbers.forEach(System.out::println); // 연산자 활용가능
		//= numbers.forEach(x -> System.out.println(x));
	}
	
	public static void runThread() {
		new Thread(new Runnable() {
		    @Override
		    public void run() {
		        System.out.println("Hello from thread");
		    }
		}).start();
	}

    public static int sum(List<Integer> numbers) {
        int total = 0;
        for (int number : numbers) {
            if(true){
                total += number;
            }
        }
        return total;
    }


    public static int sum(List<Integer> numbers, Conditional conditional) {
        int total = 0;
        for (int number : numbers) {
            if(conditional.test(number)){
                total += number;
            }
        }
        return total;
    }


	public static int sumAll(List<Integer> numbers) {
	    return sum(numbers, number -> true);
	}

	public static int sumAllEven(List<Integer> numbers) {
	    return sum(numbers, number -> number % 2 ==0);
	}

	public static int sumAllOverThree(List<Integer> numbers) {
	    return sum(numbers, number -> number > 3);
	}
}
