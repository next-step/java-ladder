package ladder;

import java.util.List;
import java.util.Objects;

public class Row {

    private final List<Boolean> points;

    private Row(List<Boolean> points) {
        this.points = points;
    }

    public static Row from(List<Boolean> points) {
        return new Row(points);
    }

    public List<Boolean> getPoints() {
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
        Row row = (Row) o;
        return Objects.equals(points, row.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
