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
        return sum(numbers, number -> true);
    }

    public static int sumAllEven(List<Integer> numbers) {
        return sum(numbers, number -> {
            if (number % 2 == 0) {
                return true;
            }
            return false;
        });
    }

    public static int sumAllOverThree(List<Integer> numbers) {
        return sum(numbers, number -> {
            if (number > 3) {
                return true;
            }
            return false;
        });
    }

    private static int sum(List<Integer> numbers, Conditional c) {
        int total = 0;
        for (int number : numbers) {
            if (c.test(number)) {
                total += number;
            }
        }
        return total;
    }
}
