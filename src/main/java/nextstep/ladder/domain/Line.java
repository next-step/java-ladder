package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private static final RandomLineStrategy RANDOM_LINE_STRATEGY = new RandomLineStrategy();

    private final List<Point> points;

    public Line(int numberOfParticipants) {
        this.points = new ArrayList<>();

        Point point = new Point();
        for (int i = 1; i < numberOfParticipants; i++) {
            point = point.next(RANDOM_LINE_STRATEGY);
            this.points.add(point);
        }
    }

    public String toLadderLine() {
        StringBuilder line = new StringBuilder("    |");
        for (Point point : this.points) {
            line.append(point.link());
        }

        return line.toString();
    }

    public List<Point> points() {
        return points;
    }
}
