package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomLineGenerator implements LineGenerator{

    private final Random random = new Random();

    @Override
    public List<Boolean> generate(int numberOfPlayers) {
        List<Boolean> points = new ArrayList<>();

        boolean previous = random.nextBoolean();
        for (int i = 0; i < numberOfPlayers - 1; i++) {
            boolean current = random.nextBoolean();

            current = getCurrentByPrevious(previous, current);

            points.add(current);

            previous = current;
        }

        return points;
    }

    private boolean getCurrentByPrevious(boolean previous, boolean current) {
        if (previous && current) {
            return false;
        }
        return current;
    }
}
