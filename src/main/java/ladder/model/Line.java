package ladder.model;

import ladder.util.LinePointGenerator;
import java.util.Collections;
import java.util.List;

public class Line {
    private List<Point> points;

    private Line (List<Point> points) {
        if (points == null || points.isEmpty()) {
            throw new IllegalArgumentException();
        }

        this.points = points;
    }

    public static Line from(List<Point> points) {
        return new Line(points);
    }

    public static Line from(int countOfParticipants) {
        return new Line(LinePointGenerator.generate(countOfParticipants));
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    public int moveFrom(int index) {
        return points.get(index).nextPosition();
    }

    public int pointSize() {
        return points.size();
    }
}
