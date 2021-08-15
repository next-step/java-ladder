package nextstep.fp;

import java.util.List;
import java.util.stream.Collectors;

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
        return numbers.stream().reduce(0, Integer::sum);
    }

    public static int sumAllEven(List<Integer> numbers) {
        Conditional c = num -> num % 2 == 0;
        return sumAll(numbers.stream().filter(num -> c.test(num)).collect(Collectors.toList()));
    }

    public static int sumAllOverThree(List<Integer> numbers) {
        Conditional c = num -> num > 3;
        return sumAll(numbers.stream().filter(num -> c.test(num)).collect(Collectors.toList()));
    }
}
