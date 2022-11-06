package ladder.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class RandomLinkStrategy implements LinkStrategy {

    private final static Random random = new Random();

    @Override
    public List<Integer> link(int column) {
        List<Integer> result = new ArrayList<>();
        IntStream.range(0, column)
            .filter(i -> random.nextBoolean() && !result.contains(i - 1))
            .forEach(result::add);

        return result;
    }
}
