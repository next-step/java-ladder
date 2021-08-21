package nextstep.fp;

import java.util.List;

public class Lambda {

    private static Conditional biggerThanThree = number -> number > 3;
    private static Conditional evenNumber = number -> number % 2 == 0;

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

    public static int sumAllOverThreeAndEven(List<Integer> numbers) {
        return numbers.stream()
            .filter(biggerThanThree::isSatisfied)
            .filter(evenNumber::isSatisfied)
            .reduce(Integer::sum).get();
    }

    public static int sumAllOverThree(List<Integer> numbers) {
        return numbers.stream()
            .filter(biggerThanThree::isSatisfied)
            .reduce(Integer::sum).get();
    }
}
