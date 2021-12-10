package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {

    private final List<Point> points = new ArrayList<>();

    public Line(int players, LadderStrategy strategy) {
        points.add(new Point());
        for (int i = 0; i < players - 1; i++) {
            points.add(new Point(i + 1, Direction.createDirection(points.get(i).isRight(), strategy)));
        }
    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    @Override
    public String toString() {
        return points + " ";
    }


}
