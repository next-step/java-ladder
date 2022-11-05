package ladder.domain;

import java.util.List;
import ladder.strategy.LinkStrategy;

public class Line {

    private final static String ERROR_EMPTY_VALUE = "입력 값이 누락되었습니다.";

    private final List<Point> points;

    public Line(final List<Point> points) {
        validate(points);
        this.points = points;
    }

    private void validate(final List<Point> value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException(ERROR_EMPTY_VALUE);
        }
    }

    public void link(final LinkStrategy strategy) {
        List<Integer> linked = strategy.link(points.size() - 1);
        points.stream()
            .filter(point -> linked.contains(point.getY()))
            .forEach(Point::link);
    }

    public List<Point> getPoints() {
        return points;
    }
}
