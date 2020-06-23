package domain;

import generator.PointGenerator;
import generator.RandomPointGenerator;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final int FIRST_INDEX = 0;
    private final boolean FINAL_FLAG = false;
    private final List<Boolean> points;

    private Line(int countOfPerson, PointGenerator pointGenerator) {
        this.points = createPoints(countOfPerson, pointGenerator);
    }

    public static Line of(int countOfPerson) {
        return new Line(countOfPerson, new RandomPointGenerator());
    }

    public static Line of(int countOfPerson, PointGenerator pointGenerator) {
        return new Line(countOfPerson, pointGenerator);
    }

    private List<Boolean> createPoints(int length, PointGenerator pointGenerator) {
        List<Boolean> points = new ArrayList<>();
        points.add(pointGenerator.isConnect(false));
        for (int i = 1; i < length - 1; i++) {
            points.add(pointGenerator.isConnect(points.get(i - 1)));
        }
        points.add(FINAL_FLAG);
        return points;
    }

    public int getPersonSize() {
        return points.size();
    }

    public List<Boolean> getPoints() {
        return points;
    }

    public int nextPointIndex(int index) {
        if (index == FIRST_INDEX) {
            return points.get(index) ? ++index : index;
        }

        if (points.get(index) == true) {
            return ++index;
        }

        return points.get(index - 1) ? --index : index;
    }
}
