package nextstep.ladder.domain;

import nextstep.ladder.domain.strategy.CreateStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Line {
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


    public Position move(Position position) {
        final Point point = this.points.get(position.get());
        final Direction direction = point.move();
        return position.move(direction);
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
                .map(p -> DELIMITER_STR + p.toString())
                .collect(Collectors.joining());
    }
}
