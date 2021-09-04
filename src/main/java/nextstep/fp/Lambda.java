package nextstep.fp;

import java.util.List;

public class Lambda {
    private static final int EVEN_NUMBER = 2;
    private static final int EVEN_REMAINDER = 0;
    private static final int FILTER_NUMBER = 3;
    private static final int INIT_TOTAL_VALUE = 0;

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
        return numbers.stream()
                .reduce(INIT_TOTAL_VALUE, Integer::sum);
    }

    public static int sumAllEven(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % EVEN_NUMBER == EVEN_REMAINDER)
                .reduce(INIT_TOTAL_VALUE , Integer::sum);
    }

    public static int sumAllOverThree(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number > FILTER_NUMBER)
                .reduce(INIT_TOTAL_VALUE, Integer::sum);
    }
}
