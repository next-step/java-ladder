package step4.domain.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import step4.domain.user.Users;
import step4.strategy.DirectionGenerateStrategy;

public class LadderLine {

    private final List<Point> points;

    private LadderLine(List<Point> points) {
        this.points = points;
    }

    static LadderLine of(List<Point> points) {
        return new LadderLine(points);
    }

    public static LadderLine createLine(Users users, DirectionGenerateStrategy strategy) {
        List<Point> points = new ArrayList<>();
        Point point = createFirst(strategy, points);
        point = createBody(users, strategy, points, point);
        createLast(points, point);
        return new LadderLine(points);
    }

    private static Point createFirst(DirectionGenerateStrategy strategy, List<Point> points) {
        Point point = Point.first(strategy);
        points.add(point);
        return point;
    }

    private static Point createBody(Users users, DirectionGenerateStrategy strategy, List<Point> points, Point point) {
        for (int i=1; i < users.usersCount() - 1; i++){
            point = point.next(strategy);
            points.add(point);
        }
        return point;
    }

    private static void createLast(List<Point> points, Point point) {
        point = point.last();
        points.add(point);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LadderLine that = (LadderLine) o;
        return Objects.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

}
