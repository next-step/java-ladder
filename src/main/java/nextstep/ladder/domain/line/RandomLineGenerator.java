package nextstep.ladder.domain.line;

import java.util.Random;

public class RandomLineGenerator implements LineGenerator {
    private final Random RANDOM = new Random();
    private boolean previous;

    @Override
    public boolean draw() {
        boolean current = RANDOM.nextBoolean();

        if (previous && (previous == current)) {
            previous = !current;
            return !current;
        }

        previous = current;
        return current;
    }
}
