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

    public static int sumWithCondition(List<Integer> numbers, Conditional conditional) {
        return numbers.stream()
                .filter(conditional::meetsCondition)
                .reduce(0, Integer::sum);
    }

    public static int sumAll(List<Integer> numbers) {
        return sumWithCondition(numbers, number -> true);
    }

    public static int sumAllEven(List<Integer> numbers) {
        return sumWithCondition(numbers, Lambda::isEvenNumber);
    }

    private static boolean isEvenNumber(int n) {
        return n % 2 == 0;
    }

    public static int sumAllOverThree(List<Integer> numbers) {
        return sumWithCondition(numbers, Lambda::isOverThree);
    }

    private static boolean isOverThree(int n) {
        return n > 3;
    }
}
