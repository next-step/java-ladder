package nextstep.fp;

import java.util.List;

public class Lambda {

    private static final int DEFAULT_RESULT = 0;

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

    public static int sumByCondition(List<Integer> numbers, SumCondition condition) {
        return numbers.stream().filter(condition::filter).reduce(Integer::sum).orElse(DEFAULT_RESULT);
    }
}
