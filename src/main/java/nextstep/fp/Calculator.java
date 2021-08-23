package nextstep.fp;

import java.util.List;

public class Calculator {
    public static int sumAll(List<Integer> numbers, Conditional conditional) {
        int total = 0;
        for (Integer number: numbers) {
            if (conditional.test(number)) {
                total += number;
            }
        }
        return total;
    }

    public static int sumAllEven(List<Integer> numbers, Conditional conditional) {
        int total = 0;
        for (int number : numbers) {
            if (conditional.test(number)) {
                total += number;
            }
        }
        return total;
    }

    public static int sumAllOverThree(List<Integer> numbers, Conditional conditional) {
        int total = 0;

        for (int number : numbers) {
            if (conditional.test(number)) {
                total += number;
            }
        }

        return total;
    }

    public static int sumAllByCondition(List<Integer> numbers, Conditional conditional) {
        int total = 0;
        for (int number: numbers) {
            if (conditional.test(number)) {
                total+= number;
            }
        }
        return total;

//        return numbers.stream()
//                .filter(integer -> conditional.test(integer))
//                .reduce(0, (x,y) -> x+y);

//        return numbers.stream()
//                .filter(conditional::test)
//                .reduce(0, Integer::sum);
    }

}
