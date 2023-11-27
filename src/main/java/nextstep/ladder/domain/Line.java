package nextstep.ladder.domain;

import nextstep.ladder.domain.strategy.CreateStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Line {
    private static final String EXIST_POINT_STR = "-----";
    private static final String EMPTY_POINT_STR = "     ";
    private static final String DELIMITER_STR = "|";
    private List<Point> points;

    public Line(int width, CreateStrategy strategy) {
        List<Point> points = new ArrayList<>();
        Point point = Point.first(strategy.generate());
        points.add(point);

        for (int i = 1; i < width - 1; i++) {
            point = point.next(strategy.isCreate(point));
            points.add(point);
        }

        points.add(point.last());

        this.points = points;
    }

    private String getRadderStr(boolean point) {
        if (point) {
            return EXIST_POINT_STR;
        }

        return EMPTY_POINT_STR;
    }

    public Position move(final Position startPosition) {
        if (startPosition.isFirstPosition()) {
            return startPosition.movePostPosition(points);
        }

        if (startPosition.isLastPosition(this.points)) {
            return startPosition.movePrePosition(this.points);
        }

        return startPosition.move(points);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    @Override
    public String toString() {
        return this.points.stream()
                .map(this::getRadderStr)
                .collect(Collectors.joining(DELIMITER_STR, DELIMITER_STR, DELIMITER_STR));
    }
}
