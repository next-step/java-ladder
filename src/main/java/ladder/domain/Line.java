package ladder.domain;

import java.util.List;

public class Line {
    private final List<Boolean> points;

    private Line(List<Boolean> points) {
        this.points = points;
    }

    public static Line of(int countOfParticipants, LineStrategy lineStrategy) {
        return new Line(lineStrategy.initialPoints(countOfParticipants));
    }

    public static Line from(List<Boolean> points) {
        return new Line(points);
    }

    public List<Boolean> getPoints() {
        return List.copyOf(points);
    }
}
