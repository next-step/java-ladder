package ladder.ladder;

import java.util.List;
import java.util.Objects;

public class Row {

    private final List<Boolean> points;

    public Row(List<Boolean> points) {
        this.points = points;
    }

    public List<Boolean> getPoints() {
        return points;
    }

    public Position move(Position position) {
        if (points.get(position.getPosition())) {
            return position.moveRight();
        }

        if (position.getPosition() > 0 && points.get(position.getPosition() - 1)) {
            return position.moveLeft();
        }
        return position;
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
