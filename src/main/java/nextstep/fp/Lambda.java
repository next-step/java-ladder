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
        new Thread(() -> System.out.println("Hello from thread")).start();
    }

    public static int sum(List<Integer> numbers, Conditional c) {
        int total = 0;
        for (int number : numbers) {
            total += filterByCondition(c, number);
        }
        return total;
    }

    private static int filterByCondition(Conditional c, int number) {
        if (c.test(number))
            return number;
        return 0;
    }
}
