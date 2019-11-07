package nextstep.fp;

import java.util.List;

public class Lambda {
    public static void printAllOld(List<Integer> numbers) {
        System.out.println("printAllOld");
        numbers.forEach(System.out::println);
    }

    public static void printAllLambda(List<Integer> numbers) {
        System.out.println("printAllLambda");
        numbers.forEach(System.out::println);
    }

    public static void runThread() {
        new Thread(() -> System.out.println("Hello from thread")).start();
    }

    public static int sumAll(List<Integer> numbers, SumCondition condition) {
        return numbers.stream()
                .filter(condition::canSum)
                .reduce(0, Integer::sum);
    }

    public static int sumAllEven(List<Integer> numbers, SumCondition condition) {
        return numbers.stream()
                .filter(condition::canSum)
                .reduce(0, Integer::sum);
    }

    public static int sumAllOverThree(List<Integer> numbers,SumCondition condition) {
        return numbers.stream()
                .filter(condition::canSum)
                .reduce(0, Integer::sum);
    }
}
