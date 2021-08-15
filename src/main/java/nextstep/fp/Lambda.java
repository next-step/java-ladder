package nextstep.fp;

import java.util.List;

public class Lambda {

    public static final int NUMBER_ZERO = 0;

    public static final int NUMBER_TWO = 2;

    public static final int NUMBER_THREE = 3;

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

    public static int sumAll(List<Integer> numbers, Conditional c) {
        return numbers.stream()
            .mapToInt(number -> number)
            .filter(number -> (c.isHasCondition(number)))
            .sum();
    }

    public static int sumAllEven(List<Integer> numbers) {
        return sumAll(numbers,number -> number % NUMBER_TWO == NUMBER_ZERO);
    }

    public static int sumAllOverThree(List<Integer> numbers) {
        return sumAll(numbers,number -> number > NUMBER_THREE);
    }
}
