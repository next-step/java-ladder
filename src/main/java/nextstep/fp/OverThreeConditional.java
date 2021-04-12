package nextstep.fp;

import java.util.List;
import java.util.function.Predicate;

public class OverThreeConditional implements Conditional {
    private static final int ZERO = 0;

    @Override
    public int calculate(List<Integer> numbers) {
        return numbers
            .stream()
            .filter(OverThreeFilter())
            .reduce(ZERO, Integer::sum);
    }

    private Predicate<Integer> OverThreeFilter() {
        return number -> number > 3;
    }
}
