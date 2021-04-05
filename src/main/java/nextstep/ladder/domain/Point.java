package nextstep.ladder.domain;

import java.util.Objects;

public class Point {

    public final boolean flag;

    private Point(final boolean flag) {
        this.flag = flag;
    }

    public static Point valueOf(final boolean flag) {
        return new Point(flag);
    }

    public static Point init() {
        return new Point(false);
    }

    public boolean isExist() {
        return flag;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        final Point point = (Point) o;
        return flag == point.flag;
    }

    @Override
    public int hashCode() {
        return Objects.hash(flag);
    }

    @Override
    public String toString() {
        return String.valueOf(flag);
    }
}
