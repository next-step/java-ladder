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
        Condition condition = number -> true;
        return numbers.stream()
                .filter(condition::checkCondition)
                .mapToInt(number -> number)
                .sum();
    }

    public static int sumAllEven(List<Integer> numbers) {
        Condition condition = number -> number % 2 == 0;
        return numbers.stream()
                .filter(condition::checkCondition)
                .mapToInt(number -> number)
                .sum();
    }

    public static int sumAllOverThree(List<Integer> numbers) {
        Condition condition = number -> number > 3;
        return numbers.stream()
                .filter(condition::checkCondition)
                .mapToInt(number -> number)
                .sum();
    }
}
