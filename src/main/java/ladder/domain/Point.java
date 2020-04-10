package ladder.domain;

import ladder.domain.type.DirectionType;
import lombok.Getter;

import java.util.Objects;

public class Point {
    private final int index;
    @Getter
    private final DirectionType directionType;

    public Point(int index, DirectionType directionType) {
        this.index = index;
        this.directionType = directionType;
    }

    public int move() {
        return this.index + this.directionType.getMove();
    }

    public Point next() {
        return new Point(index + 1, directionType.next());
    }

    public Point last() {
        return new Point(index + 1, directionType.last());
    }

    public static Point first(Boolean right) {
        return new Point(0, DirectionType.first(right));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return index == point.index &&
                directionType == point.directionType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, directionType);
    }
}
