package ladder.domain;

import ladder.domain.strategy.GeneratorInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {
    private static final int WIHTOUT_FIRST_AND_END = 2;
    private final List<Point> linePoint;

    public Line(List<Point> pointList) {
        linePoint = pointList;
    }

    public int move(int point) {
        return linePoint.get(point).move();
    }

    public List<Point> getPoints() {
        return linePoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(linePoint, line.linePoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(linePoint);
    }

    @Override
    public String toString() {
        return "Line{" +
                "linePoint=" + linePoint +
                '}';
    }

    public static Line create(int size, GeneratorInterface strategy) {
        List<Point> list = new ArrayList<>();
        Point point = Point.first(strategy.generate());
        list.add(point);
        for (int i = 0 ; i < size - WIHTOUT_FIRST_AND_END ; i++) {
            point = point.next(strategy);
            list.add(point);
        }
        list.add(point.last());

        return new Line(list);
    }
}
