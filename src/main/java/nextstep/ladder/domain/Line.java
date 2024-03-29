package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Boolean> points = new ArrayList<>();

    public Line(final Generator generator, final int numberOfPeople) {
        while (points.size() < numberOfPeople - 1) {
            final boolean now = generator.generate();
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
