package ladder.domain;

import java.util.Objects;

public class Point {

    public static final int LADDER_WIDTH = 5;
    public static final String EXIST_MARK = "-";
    public static final String NON_EXIST_MARK = " ";
    public static final String PREFIX = "|";
    private final boolean isExist;

    public Point(boolean isExist) {
        this.isExist = isExist;
    }

    public boolean isEqualToTrue(Point y) {
        return y.express(this.isExist);
    }

    private boolean express(boolean b) {
        return this.isExist && b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return isExist == point.isExist;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isExist);
    }

    @Override
    public String toString() {
        if (this.isExist) {
            return PREFIX + EXIST_MARK.repeat(LADDER_WIDTH);
        }
        return PREFIX + NON_EXIST_MARK.repeat(LADDER_WIDTH);
    }
}
