package domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    public static Line initialize(Participants participants, PointGenerateStrategy strategy) {
        List<Point> points = new ArrayList<>();

        Point point = Point.first();
        points.add(point);

        for (int i = 1; i < participants.countOfParticipants(); i++) {
            point = Point.of(point, strategy.canMake());
            points.add(point);
        }

        return new Line(points);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        points.forEach(point -> stringBuilder.append(point.toString()));
        return stringBuilder.toString();
    }
}
