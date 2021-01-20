package nextstep.fp;

import java.util.List;
import java.util.function.Predicate;

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

    public static int sumAll(List<Integer> numbers, Conditional conditinal) {
        int total = numbers.stream()
                .filter(conditinal::test)
                .mapToInt(Integer::new).sum();
        return total;
    }

    public static int sumAllEven(List<Integer> numbers) {
        int total = sum( numbers,(number)->number %2 ==0);
        return total;
    }

    public static int sumAllOverThree(List<Integer> numbers) {
        int total = sum( numbers,(number) -> number > 3);
        return total;
    }

    public static int sum(List<Integer> numbers, Conditional conditional){
        int total = numbers.stream()
                .filter(conditional::test).mapToInt(Integer::new).sum();
        return total;
    }


}
