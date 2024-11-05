package nextstep.fp;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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

    public static int sumAll(List<Integer> numbers, Calculator calculator) {
        AtomicInteger total = new AtomicInteger(0);
        numbers.forEach(number -> total.set(calculator.plus(number, total.get())));

        return total.get();
    }
}
