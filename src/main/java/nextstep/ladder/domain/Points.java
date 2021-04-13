package nextstep.ladder.domain;

import nextstep.ladder.strategy.ConnectStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Points {
    private final List<Point> points;

    public Points(int countOfPlayer, ConnectStrategy connectStrategy) {
        this(new CountOfPlayer(countOfPlayer), connectStrategy);
    }

    public Points(CountOfPlayer countOfPlayer, ConnectStrategy connectStrategy) {
        this(createWith(countOfPlayer, connectStrategy));
    }

    public Points(List<Point> points) {
        this.points = points;
    }

    public static List<Point> createWith(CountOfPlayer countOfPlayer, ConnectStrategy connectStrategy) {
        List<Point> points = new ArrayList<>(countOfPlayer.number());
        Point point = Point.first(connectStrategy);
        points.add(point);

        while (point.isNotLast(countOfPlayer.number())) {
            point = point.next();
            points.add(point);
        }

        points.add(point.last());

        return points;
    }

    public List<Point> points() {
        return points;
    }

    public List<Boolean> pointsConnection() {
        return this.points.stream()
                .map(Point::hasRightDirection)
                .limit(points().size() - 1)
                .collect(Collectors.toList());
    }
}
