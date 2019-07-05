package nextstep.step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    public static Line createByRandomPoint(final int playerCount) {
        List<Point> points = new ArrayList<>();
        points.add(Point.createFirst(new RandomPointCreationStrategy()));

        final var lastPoint = playerCount - 2;
        for (int i = 0; i < lastPoint; i++) {
            points.add(points.get(i).createNext(new RandomPointCreationStrategy()));
        }

        points.add(points.get(lastPoint).createLast());
        return new Line(points);
    }

    public Point getPoint(final int index) {
        return this.points.get(index);
    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "Line : " + points;
    }
}
