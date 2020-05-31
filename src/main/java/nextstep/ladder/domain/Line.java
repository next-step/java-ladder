package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Point> points;

    public Line(int countOfPerson) {
        this(PointFactory.of(countOfPerson));
    }

    public Line(List<Point> points) {
        validatePoints(points);
        this.points = points;
    }

    private void validatePoints(List<Point> points) {
        if (points.isEmpty()) {
            throw new IllegalArgumentException("invalid size of points");
        }

        for (int i = 1; i < points.size(); i++) {
            Point current = points.get(i);
            if (!current.isValid(points.get(i - 1))) {
                throw new IllegalArgumentException("invalid point");
            }
        }
    }

    public List<Point> getPoints() {
        return new ArrayList<>(this.points);
    }
}
