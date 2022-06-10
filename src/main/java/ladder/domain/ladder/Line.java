package ladder.domain.ladder;

import java.util.*;

import static ladder.domain.RandomGenerator.generate;

public class Line {
    private List<Point> points;

    public Line(int countOfPerson) {
        this(createConnections(countOfPerson));
    }

    public Line(List<Point> connectionList) {
        points = connectionList;
    }

    private static List<Point> createConnections(int person) {
        List<Point> tmpConnectionList = new ArrayList<>();

        Point point = Point.first(generate());
        tmpConnectionList.add(point);

        for (int i = 1; i < person-1; i++) {
            point = point.next();
            tmpConnectionList.add(point);
        }

        point = point.last();
        tmpConnectionList.add(point);

        return tmpConnectionList;
    }

    public int move(int width) {
        return points.get(width).move();
    }

    public List<Point> getPoints() {
        return points;
    }
}
