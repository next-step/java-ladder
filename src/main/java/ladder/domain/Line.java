package ladder.domain;

import ladder.strategy.ConnectionStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Line {
    private static final Integer START_LINE_BODY_INDEX = 2;

    private final List<Point> points = new ArrayList<>();

    public Line(int countOfPerson, ConnectionStrategy connection) {
        Point point = Point.first(connection.isConnected());
        this.points.add(point);

        for (int i = START_LINE_BODY_INDEX; i < countOfPerson; i++) {
            point = point.next(connection.isConnected());
            this.points.add(point);
        }

        this.points.add(point.last());
    }

    public List<Boolean> currentPoints() {
        return points.stream()
                .map(Point::getCurrent)
                .collect(Collectors.toList());
    }
}
