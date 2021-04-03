package nextstep.ladder.domain;

import java.util.Objects;

public class Point {

    public final boolean flag;

    private Point(final boolean flag) {
        this.flag = flag;
    }

    public static Point of(boolean flag) {
        return new Point(flag);
    }

    public static Point initFalse() {
        return new Point(false);
    }

    public boolean isExist() {
        return flag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
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
