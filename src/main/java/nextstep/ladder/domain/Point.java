package nextstep.ladder.domain;

import java.util.Objects;

public class Point {
    private final int position;

    public Point(final int position) {
        // TODO: 최대높이에 대한 Validation
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return position == point.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
