package nextstep.ladder.domain.ladder;

import nextstep.ladder.util.ConnectStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LadderLine {
    private final List<Point> points;

    public LadderLine(List<Point> points) {
        this.points = points;
    }

    public static LadderLine from(int sizeOfPerson, ConnectStrategy connectStrategy) {
        List<Point> points = new ArrayList<>();

        Point point = initHead(connectStrategy, points);
        point = initBody(sizeOfPerson, connectStrategy, points, point);
        initLast(points, point.last());

        return new LadderLine(points);
    }

    private static Point initHead(ConnectStrategy connectStrategy, List<Point> points) {
        Point point = Point.first(connectStrategy);
        points.add(point);
        return point;
    }

    private static Point initBody(int sizeOfPerson, ConnectStrategy connectStrategy, List<Point> points, Point point) {
        for (int i = 1; i <= sizeOfPerson - 2; i++) {
            point = point.next(connectStrategy);
            points.add(point);
        }
        return point;
    }

    private static boolean initLast(List<Point> points, Point last) {
        return points.add(last);
    }

    @Override
    public String toString() {
        return points.stream()
                .map(Point::toString)
                .collect(Collectors.joining());
    }
}
