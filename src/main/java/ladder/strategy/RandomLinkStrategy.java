package ladder.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import ladder.domain.PositiveInt;

public class RandomLinkStrategy implements LinkStrategy {

    private final static Random random = new Random();

    @Override
    public List<PositiveInt> link(final int column) {
        List<PositiveInt> result = new ArrayList<>();
        IntStream.range(0, column)
            .filter(i -> isLinkable(i, result))
            .mapToObj(PositiveInt::new)
            .forEach(result::add);

        return result;
    }

    private boolean isLinkable(final int index, final List<PositiveInt> linked) {
        int previous = index - 1;
        if (index == 0) {
            previous = 0;
        }

        return random.nextBoolean() && !linked.contains(new PositiveInt(previous));
    }
}
