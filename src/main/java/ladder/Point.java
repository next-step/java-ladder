package ladder;

import java.util.Objects;

import static util.Preconditions.checkArgument;

public class Point {
    public static final String POINT_MUST_HAS_ONLY_ONE_DIRECTION = "point must has only one direction";
    private final int index;
    private final boolean horizontal;
    private final boolean vertical;
    private final boolean empty;

    private Point(int index, boolean horizontal, boolean vertical, boolean empty) {
        this.index = index;
        this.horizontal = horizontal;
        this.vertical = vertical;
        this.empty = empty;
    }

    public static Point of(final int index, final boolean horizontal, final boolean vertical) {
        checkArgument(!(horizontal && vertical), POINT_MUST_HAS_ONLY_ONE_DIRECTION);
        final boolean hasDirection = horizontal || vertical;
        return new Point(index, horizontal, vertical, hasDirection);
    }

    public static Point createEmpty(final int index) {
        return of(index, false, false);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return index == point.index &&
                horizontal == point.horizontal &&
                vertical == point.vertical &&
                empty == point.empty;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, horizontal, vertical, empty);
    }
}