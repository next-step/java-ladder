package ladder.ladder;

import java.util.List;
import java.util.Objects;

public class Row {

    private final List<Point> points;

    public Row(List<Point> points) {
        this.points = points;
    }

    public List<Point> getPoints() {
        return points;
    }

    public Position move(Position position) {
        return points.get(position.getPosition()).move();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Row row = (Row) o;
        return Objects.equals(points, row.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
