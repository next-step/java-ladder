package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private static final RandomLineStrategy RANDOM_LINE_STRATEGY = new RandomLineStrategy();

    private final List<Point> points;

    public Line(int numberOfParticipants) {
        this.points = new ArrayList<>();

        for (int i = 0; i < numberOfParticipants - 1; i++) {
            this.points.add(nextPoint(i));
        }
    }

    private Point nextPoint(int index) {
        if (index == 0) {
            return new Point().next(RANDOM_LINE_STRATEGY);
        }
        if (this.points.get(index - 1).linked()) {
            return new Point();
        }

        return new Point().next(RANDOM_LINE_STRATEGY);
    }

    public List<Point> points() {
        return points;
    }

    public int numberOfParticipants() {
        return this.points.size() + 1;
    }
}
