package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Line {

    private List<Boolean> points = new ArrayList<>();
    private Random random = new Random();

    public Line(int numberOfPlayers) {
        boolean previous = random.nextBoolean();

        for (int i = 0; i < numberOfPlayers - 1; i++) {
            boolean current = random.nextBoolean();

            current = getCurrentByPrevious(previous, current);

            points.add(current);
            previous = current;
        }
    }

    private boolean getCurrentByPrevious(boolean previous, boolean current) {
        if (previous && current) {
            return false;
        }
        return current;
    }

    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
