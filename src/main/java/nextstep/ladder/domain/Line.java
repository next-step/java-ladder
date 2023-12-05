package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = new ArrayList<>(points);
    }

    public static Line make(int pointCount) {
        List<Point> points = new ArrayList<>();
        StepFactory stepFactory = new StepFactory();
        for (int i = 0; i < pointCount; i++) {
            points.add(Point.make(i, pointCount, stepFactory));
        }
        return new Line(points);
    }

    public int following(int index) {
        return index + points.get(index).moving();
    }

    public List<Point> getLine() {
        return Collections.unmodifiableList(points);
    }
}
