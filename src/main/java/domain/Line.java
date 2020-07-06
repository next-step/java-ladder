package domain;

import generator.PointGenerator;
import generator.RandomPointGenerator;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Point> points;

    private Line(int countOfPerson, PointGenerator pointGenerator) {
        this.points = createPoints(countOfPerson, pointGenerator);
    }

    public static Line of(int countOfPerson) {
        return new Line(countOfPerson, new RandomPointGenerator());
    }

    public static Line of(int countOfPerson, PointGenerator pointGenerator) {
        return new Line(countOfPerson, pointGenerator);
    }

    private List<Point> createPoints(int length, PointGenerator pointGenerator) {
        List<Point> points = new ArrayList<>();
        points.add(Point.first(pointGenerator.random()));
        for (int i = 1; i < length - 1; i++) {
            points.add(points.get(i-1).next(pointGenerator));
        }
        points.add(points.get(points.size() - 1).last());

        return points;
    }

    public int getPersonSize() {
        return points.size();
    }

    public List<Point> getPoints() {
        return points;
    }

    public int nextPointIndex(int index) {
        return points.get(index).move(index);
    }
}
