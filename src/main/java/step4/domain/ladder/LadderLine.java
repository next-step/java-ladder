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
        Point point = Point.first(strategy);
        points.add(point);
        for (int i=1; i < users.usersCount() - 1; i++){
            point = point.next(strategy);
            points.add(point);
        }
        point = point.last();
        points.add(point);
        return new LadderLine(points);
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
