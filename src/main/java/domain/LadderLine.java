package domain;

import java.util.ArrayList;
import java.util.List;

public class LadderLine implements Line {

    private List<Point> points;

    LadderLine(List<Point> points) {
        this.points = points;
    }

    public static LadderLine initialize(int participantCount, ValueGenerator generator) {
        List<Point> points = new ArrayList<>();

        Point point = Point.first(generator.generate());
        points.add(point);

        for (int i = 1; i < participantCount - 1; i++) {
            point = point.next(generator.generate());
            points.add(point);
        }

        points.add(point.last());

        return new LadderLine(points);
    }

    @Override
    public Position move(Position current) {
        Point point = points.get(current.value());

        if (point.canMoveLeft()) {
            return current.prev();
        }

        if (point.canMoveRight()) {
            return current.next();
        }

        return current;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        points.forEach(point -> builder.append(point.toString()));
        return builder.toString();
    }
}
