package nextstep.fp;

import java.util.List;

public class Lambda {

    private static final Integer RANGE_NUMBER = 3;
    private static final Integer INIT_NUMBER = 0;
    private static final Integer EVEN_NUMBER = 2;

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
        return Calculator.sumAllByCondition(numbers, number -> true);
    }

    public static int sumAllEven(List<Integer> numbers) {
        return Calculator.sumAllByCondition(numbers, number -> number % EVEN_NUMBER == INIT_NUMBER);
    }

    public static int sumAllOverThree(List<Integer> numbers) {
        return Calculator.sumAllByCondition(numbers, number -> number > RANGE_NUMBER);
    }
}
