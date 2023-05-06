package nextstep.fp;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

    public static int sumWithCondition(List<Integer> numbers, Predicate<Integer> satisfyCondition) {

        List<Integer> sum = filterSatisfyNumber(numbers, satisfyCondition);

        return sum.stream().reduce(0,Integer::sum);
    }

    public static int sumAll(List<Integer> numbers) {
        return sumWithCondition(numbers, number -> true);
    }

    public static int sumAllEven(List<Integer> numbers) {
        return sumWithCondition(numbers, Lambda::isEvenNumber);
    }

    private static boolean isEvenNumber(int n) {
        return n % 2 == 0;
    }

    public static int sumAllOverThree(List<Integer> numbers) {
        return sumWithCondition(numbers, Lambda::isOverThree);
    }

    private static boolean isOverThree(int n) {
        return n > 3;
    }

    private static List<Integer> filterSatisfyNumber(List<Integer> numberList, Predicate<Integer> satisfyCondition) {
        return numberList.stream()
                .filter(satisfyCondition)
                .collect(Collectors.toList());
    }

}
