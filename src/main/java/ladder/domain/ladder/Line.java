package ladder.domain.ladder;

import java.util.List;

import static java.util.Collections.unmodifiableList;

public class Line {
    private List<Point> points;

    public Line (List<Point> points) {
        this.points = unmodifiableList(points);
    }

    public Position move(Position currentPosition) {
        return points.get(currentPosition.getValue()).move();
    }

    public List<Point> getPoints() {
        return points;
    }
}
