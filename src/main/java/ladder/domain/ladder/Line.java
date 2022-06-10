package ladder.domain.ladder;

import java.util.*;

import static ladder.domain.RandomGenerator.generate;

public class Line {
    private List<Point> points;

    public Line(int countOfPerson) {
        this(createPoints(countOfPerson));
    }

    public Line(List<Point> points) {
        this.points = points;
    }

    private static List<Point> createPoints(int person) {
        List<Point> tmpPoints = new ArrayList<>();

        Point point = Point.first(generate());
        tmpPoints.add(point);

        for (int i = 1; i < person-1; i++) {
            point = point.next();
            tmpPoints.add(point);
        }

        point = point.last();
        tmpPoints.add(point);

        return tmpPoints;
    }

    public int move(int width) {
        return points.get(width).move();
    }

    public List<Point> getPoints() {
        return points;
    }
}
