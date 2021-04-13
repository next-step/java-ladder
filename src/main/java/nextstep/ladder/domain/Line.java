package nextstep.ladder.domain;

import nextstep.ladder.strategy.ConnectStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Line {
    private final List<Point> points;
    private final ConnectStrategy connectStrategy;

    public Line(CountOfPlayer countOfPlayer, ConnectStrategy connectStrategy) {
        this.connectStrategy = connectStrategy;
        this.points = create(countOfPlayer.number());
    }

    private List<Point> create(int countOfPlayer) {
        List<Point> points = new ArrayList<>(countOfPlayer);
        Point point = Point.first(connectStrategy);
        points.add(point);

        for (int i = 0; i < countOfPlayer - 2; i++) {
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