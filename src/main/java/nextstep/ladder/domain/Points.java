package nextstep.ladder.domain;

import nextstep.ladder.strategy.DirectionStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Points {
    private final List<Point> points;

    public Points(int countOfPlayer, DirectionStrategy directionStrategy) {
        this(new CountOfPlayer(countOfPlayer), directionStrategy);
    }

    public Points(CountOfPlayer countOfPlayer, DirectionStrategy directionStrategy) {
        this(createWith(countOfPlayer, directionStrategy));
    }

    public Points(List<Point> points) {
        this.points = points;
    }

    public static List<Point> createWith(CountOfPlayer countOfPlayer, DirectionStrategy directionStrategy) {
        List<Point> points = new ArrayList<>(countOfPlayer.number());
        Point point = Point.first(directionStrategy);
        points.add(point);

        while (point.isNotLast(countOfPlayer.number())) {
            point = point.next(directionStrategy);
            points.add(point);
        }

        points.add(point.last());

        return points;
    }

    public List<Point> points() {
        return Collections.unmodifiableList(points);
    }

    public List<Boolean> pointsConnection() {
        return this.points.stream()
                .map(Point::hasRightDirection)
                .limit(points().size() - 1)
                .collect(Collectors.toList());
    }

    public Point findByIndex(int pointIndex) {
        return points.get(pointIndex);
    }
}
