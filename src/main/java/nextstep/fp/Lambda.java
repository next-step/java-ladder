package nextstep.fp;

import java.util.List;

public class Lambda {
    public interface Conditional {
        boolean test(Integer number);
    }
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

    public static int sumAll(Conditional c, List<Integer> numbers) {
        return numbers.stream().filter(c::test).reduce(Integer::sum).orElse(0);
    }
}
