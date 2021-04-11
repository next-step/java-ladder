package nextstep.fp;

import java.util.List;

public class SumConditional implements Conditional {
    @Override
    public int sum(List<Integer> numbers) {
        return numbers.stream().reduce(0, Integer::sum);
    }
}
