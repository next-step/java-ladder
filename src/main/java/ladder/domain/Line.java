package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class Line {

    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    public Line(int countPerson) {
        List<Point> tempPoints = new ArrayList<>();
        for(int i=0; i < countPerson; i++) {
            tempPoints.add(Point.of(new Random().nextBoolean()));
        }
        this.points = tempPoints;
    }

    public static final Line of(List<Point> points) {
        return new Line(points);
    }

}
