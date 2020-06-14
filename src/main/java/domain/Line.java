package domain;

import generator.PointGenerator;
import generator.RandomPointGenerator;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Boolean> points;

    public Line(int countOfPerson) {
        this(countOfPerson, new RandomPointGenerator());
    }

    public Line(int countOfPerson, PointGenerator pointGenerator) {
        this.points = createPoints(countOfPerson, pointGenerator);
    }

    private List<Boolean> createPoints(int length, PointGenerator pointGenerator) {
        List<Boolean> points = new ArrayList<>();
        points.add(pointGenerator.isConnect(false));
        for (int i = 1; i < length; i++) {
            points.add(pointGenerator.isConnect(points.get(i - 1)));
        }

        return points;
    }

    public int getPersonSize() {
        return points.size();
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
