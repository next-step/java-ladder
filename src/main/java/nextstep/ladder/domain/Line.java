package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {

    private List<Point> points;

    public Line(int pointSize) {
        this.points = createPoints(pointSize);
    }

    private List<Point> createPoints(int pointSize) {
        List<Point> points = new ArrayList<>();

        Point point = Point.ofFirst(createBoolean());
        points.add(point);

        for (int i = 0; i < pointSize - 2; i++) {
            point = point.createNext(createBoolean());
            points.add(point);
        }

        point = point.createLast();
        points.add(point);

        return points;
    }

    private boolean createBoolean() {
        return new Random().nextInt(2) == 0;
    }

    public int move(int current) {
        return points.get(current).move();
    }
}
