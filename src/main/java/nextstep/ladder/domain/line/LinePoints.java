package nextstep.ladder.domain.line;

import java.util.ArrayList;
import java.util.List;
import nextstep.ladder.domain.point.Point;

public class LinePoints {

    private List<Point> points;

    LinePoints(List<Point> points) {
        validate(points);
        this.points = points;
    }

    public List<Point> getPoints() {
        return new ArrayList<>(points);
    }

    private void validate(List<Point> points) {
        if (points.isEmpty()) {
            throw new IllegalArgumentException("invalid size of points");
        }

        for (int i = 1; i < points.size(); i++) {
            validatePoint(points.get(i), points.get(i - 1));
        }
    }

    private void validatePoint(Point current, Point pre) {
        if (!current.isValid(pre)) {
            throw new IllegalArgumentException("invalid point");
        }
    }
}
