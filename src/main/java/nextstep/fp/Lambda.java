package nextstep.fp;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
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

    public static int sumConditional(List<Integer> numbers, Conditional conditional) {
        int total = 0;
        for (int number : numbers) {
            if (conditional.test(number)) {
                total += number;
            }
        }
        return total;
    }

    public static int sumAll(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(n -> n)
                .sum();
    }

    public static int sumAllEven(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(n -> n)
                .filter(n -> n % 2 == 0)
                .sum();
    }

    public static int sumAllOverThree(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(n -> n)
                .filter(n -> n > 3)
                .sum();
    }

}
