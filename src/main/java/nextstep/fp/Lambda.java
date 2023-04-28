package nextstep.fp;

import java.util.List;

public class Lambda {
    private static final int DEFAULT_SUM = 0;
    private static final int EVEN_CONDITION = 2;
    private static final int OVER_CONDITION = 3;

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
                .reduce(DEFAULT_SUM, Integer::sum);
    }

    public static int sumAllEven(List<Integer> numbers) {
        return numbers.stream()
                .filter(Lambda::isEvenNumber)
                .reduce(DEFAULT_SUM, Integer::sum);
    }

    private static boolean isEvenNumber(Integer n) {
        return n % EVEN_CONDITION == DEFAULT_SUM;
    }

    public static int sumAllOverThree(List<Integer> numbers) {
        return numbers.stream()
                .filter(Lambda::isOverThree)
                .reduce(DEFAULT_SUM, Integer::sum);
    }

    private static boolean isOverThree(Integer n) {
        return n > OVER_CONDITION;
    }
}
