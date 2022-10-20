package nextstep.fp;

import java.util.List;
import java.util.function.Predicate;

public class Conditional {
    public static int test(List<Integer> numbers, Predicate<Integer> IntegerPredicate) {
        return numbers.stream()
                .filter(IntegerPredicate)
                .reduce(0, (number1, number2) -> number1 + number2);
    }
}
