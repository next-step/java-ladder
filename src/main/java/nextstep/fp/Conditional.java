package nextstep.fp;

import java.util.List;

@FunctionalInterface
public interface Conditional {

    boolean test(Integer number);

    static int sumAll(List<Integer> numbers) {
        return sumAllByCondition(numbers, number -> true);
    }

    static int sumAllEven(List<Integer> numbers) {
        return sumAllByCondition(numbers, number -> number % 2 == 0);
    }


    static int sumAllOverThree(List<Integer> numbers) {
        return sumAllByCondition(numbers, number -> number > 3);
    }

    private static int sumAllByCondition(List<Integer> numbers, Conditional conditional) {
        return numbers.stream()
            .filter(conditional::test)
            .reduce(0, Integer::sum);
    }
}
