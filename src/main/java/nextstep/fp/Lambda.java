package nextstep.fp;

import java.util.List;

public class Lambda {

    private static final int DEFAULT_VALUE = 0;

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

    public static int sumAll(List<Integer> numbers, Calculator calculator) {
        int total = DEFAULT_VALUE;
        for (int number : numbers) {
            total = calculatorSum(calculator, total, number);
        }
        return total;
    }

    public static int sumAllEven(List<Integer> numbers, Calculator calculator) {
        int total = DEFAULT_VALUE;
        for (int number : numbers) {
            total = calculatorSum(calculator, total, number);
        }
        return total;
    }

    public static int sumAllOverThree(List<Integer> numbers, Calculator calculator) {
        int total = DEFAULT_VALUE;
        for (int number : numbers) {
            total = calculatorSum(calculator, total, number);
        }
        return total;
    }

    private static int calculatorSum(Calculator calculator, int total, int number) {
        if (calculator.sum(number)) {
            total += number;
        }
        return total;
    }

}
