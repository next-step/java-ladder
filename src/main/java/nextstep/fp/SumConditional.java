package nextstep.fp;

import java.util.List;

public class SumConditional implements Conditional {
    private static final int ZERO = 0;

    @Override
    public int sum(List<Integer> numbers) {
        return numbers.stream().reduce(ZERO, Integer::sum);
    }
}
