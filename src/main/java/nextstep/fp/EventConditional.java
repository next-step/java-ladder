package nextstep.fp;

import java.util.List;
import java.util.function.Predicate;

public class EventConditional implements Conditional {
    private static final int EVEN = 2;
    private static final int ZERO = 0;

    @Override
    public int calculate(List<Integer> numbers) {
        return numbers
            .stream()
            .filter(evenFilter())
            .mapToInt(Integer::valueOf)
            .sum();
    }

    private Predicate<Integer> evenFilter() {
        return number -> number % EVEN == ZERO;
    }
}
