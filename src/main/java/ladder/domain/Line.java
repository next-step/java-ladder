package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Line {
    private List<Points> points;

    private Line(List<Points> points) {
        this.points = points;
    }

    public static Line of(List<Points> points) {
        return new Line(points);
    }

    public int getSize() {
        return points.size();
    }

    public List<Boolean> getConnection() {
        return points.stream()
                .map(Points::isRight)
                .collect(Collectors.toList());
    }

    public List<Points> getPoints() {
        return points;
    }
}
