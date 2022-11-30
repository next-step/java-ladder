package nextstep.ladder.domain;

import nextstep.ladder.exception.IllegalDirectionException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import static nextstep.ladder.domain.Direction.STRAIGHT;

public class Line {

    private static final int FIRST_POINT = 0;
    private static final int NEXT_POINT = 1;
    private final List<Point> points;

    public Line(Point point) {
        this(Arrays.asList(point));
    }

    public Line(List<Point> points) {
        this.points = validPoint(points);
    }

    public List<Point> line() {
        return points;
    }

    public int move(int startPosition) {
       return points.get(startPosition).move();
    }

    private List<Point> validPoint(List<Point> points) {
        points.get(FIRST_POINT).validFirst();

        for (int i = FIRST_POINT; i < points.size() - NEXT_POINT; i++) {
            validMiddle(points.get(i), points.get(i + NEXT_POINT));
        }
        points.get(points.size() - 1).validLast();
        return points;
    }

    private void validMiddle(Point previous, Point current) {
        if (previous.direction() == current.direction() && current.direction() != STRAIGHT) {
            throw new IllegalDirectionException("중간점은 겹칠 수 없습니다");
        }
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
}
