package ladder.domain;

import ladder.strategy.PointStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LadderLine {
    private List<Point> points;

    private LadderLine(final List<Point> points) {
        this.points = points;
    }

    public static LadderLine of(int countOfPerson, PointStrategy pointStrategy) {
        List<Point> points = new ArrayList<>();
        Point point = initFirst(points, pointStrategy);
        for (int i = 1; i < countOfPerson - 1; i++) {
            point = point.next(pointStrategy);
            points.add(point);
        }
        initLast(points, point);
        return new LadderLine(points);
    }

    private static void initLast(List<Point> points, Point point) {
        point = point.last();
        points.add(point);
    }

    private static Point initFirst(List<Point> points, PointStrategy pointStrategy) {
        Point point = Point.first(pointStrategy.generator());
        points.add(point);
        return point;
    }

    public int move(final int index) {
        return points.get(index).move();
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderLine that = (LadderLine) o;
        return Objects.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    @Override
    public String toString() {
        return "LadderLine{" +
                "points=" + points +
                '}';
    }
}
