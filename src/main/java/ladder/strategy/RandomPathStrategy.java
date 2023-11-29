package ladder.strategy;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomPathStrategy implements PathStrategy {

    private static final Random random = new Random();

    @Override
    public List<Boolean> generate(long size) {
        return Stream.iterate(random(), this::randomIfPreviousNotChecked)
                .limit(size)
                .collect(Collectors.toList());
    }

    private boolean randomIfPreviousNotChecked(boolean previous) {
        if (notChecked(previous)) {
            return random();
        }

        return false;
    }

    private boolean notChecked(boolean previous) {
        return !previous;
    }

    private Boolean random() {
        return random.nextBoolean();
    }
}
