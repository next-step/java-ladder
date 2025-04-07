package nextstep.fp;

import java.util.List;

public class Lambda {

    public static int sumAll(List<Integer> numbers) {
        return sumAll(numbers, number -> true);
    }

    public static int sumAllEven(List<Integer> numbers) {
        return sumAll(numbers, number -> number % 2 == 0);
    }

    public static int sumAllOverThree(List<Integer> numbers) {
        return sumAll(numbers, number -> number > 3);
    }

    public static int sumAll(List<Integer> numbers, Conditional c) {
        int total = 0;
        for (int number : numbers) {
            if (c.test(number)) {
                total += number;
            }
        }
        return total;
    }
}