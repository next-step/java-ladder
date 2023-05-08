package nextstep.fp;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lambda {


    private static final int ZERO = 0;
    private static final int TWO = 2;
    private static final int THREE = 3;

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

    public static int sumAll(List<Integer> numbers) {

        return numbers.stream()
                .reduce(ZERO, Integer::sum);
    }

    public static int sumAllEven(List<Integer> numbers) {

        List<Integer> evenNumbers = filterSatisfyNumber(numbers, Lambda::isEvenNumber);

        return sumAll(evenNumbers);
    }

    private static boolean isEvenNumber(int n) {
        return n % TWO == ZERO;
    }

    public static int sumAllOverThree(List<Integer> numbers) {

        List<Integer> overThreeNumbers = filterSatisfyNumber(numbers, Lambda::isOverThree);

        return sumAll(overThreeNumbers);
    }

    private static boolean isOverThree(int n) {
        return n > THREE;
    }

    private static List<Integer> filterSatisfyNumber(List<Integer> numbers, Predicate<Integer> satisfyCondition) {
        return numbers.stream()
                .filter(satisfyCondition)
                .collect(Collectors.toList());
    }

}
