package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {

    private final List<Boolean> points = new ArrayList<>();

    public Line(final int numberOfPeople) {
        final Random random = new Random();
        while (points.size() < numberOfPeople - 1) {
            final boolean now = random.nextBoolean();
            addBridge(now);
        }
    }

    private void addBridge(final boolean now) {
        if (points.isEmpty()) {
            points.add(now);
            return;
        }
        if (points.get(points.size() - 1)) {
            points.add(false);
            return;
        }
        points.add(now);
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
