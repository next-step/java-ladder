package nextstep.fp;

import nextstep.fp.function.Conditional;
import nextstep.fp.function.Operation;

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
        new Thread(() -> System.out.println("Hello from thread"))
                .start();
    }

    public static int sumAll(List<Integer> numbers) {
        return sumAllLambda(numbers, Conditional.alwaysTrue());
    }

    public static int sumAllEven(List<Integer> numbers) {
        return sumAllLambda(numbers, number -> number % 2 == 0);
    }

    public static int sumAllLambda(List<Integer> numbers, Conditional<Integer> conditional) {
        return operationLambda(numbers, conditional,
                Operation.add());
    }

    public static int operationLambda(List<Integer> numbers, Conditional<Integer> conditional, Operation operator) {
        return numbers.stream()
                .filter(conditional::test)
                .reduce(operator::formula)
                .orElse(0);
    }

    public static int sumAllOverThree(List<Integer> numbers) {
        int total = 0;
        for (int number : numbers) {
            if (number > 3) {
                total += number;
            }
        }
        return total;
    }
}
