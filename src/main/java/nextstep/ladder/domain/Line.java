package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private static final RandomLineStrategy randomLineStrategy = new RandomLineStrategy();

    private final List<Point> points;

    public Line(int numberOfParticipants) {
        this.points = new ArrayList<>();

        Point point = new Point();
        this.points.add(point.next(randomLineStrategy));

        for (int i = 1; i < numberOfParticipants - 1; i++) {
            if (this.points.get(i-1).linked()) {
                this.points.add(new Point());
                continue;
            }
            this.points.add(point.next(randomLineStrategy));
        }
    }

    public List<Point> points() {
        return points;
    }

    public int numberOfParticipants() {
        return this.points.size() + 1;
    }
}
