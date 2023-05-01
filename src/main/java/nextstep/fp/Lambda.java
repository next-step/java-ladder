package nextstep.fp;

import nextstep.fp.prediate.SumPredicate;

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

    public static int sumAllByPredicate(List<Integer> numbers, SumPredicate predicate) {
        return numbers.stream()
                         .filter(predicate::test)
                         .mapToInt(value -> value)
                         .sum();
    }
}
