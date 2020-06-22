package ladder.domain.ladder;

import java.util.Objects;

public class Point {
    private final boolean before;
    private final boolean after;

    private Point(boolean before, boolean after) {
        isNotBothTrue(before, after);
        this.before = before;
        this.after = after;
    }

    private void isNotBothTrue(boolean before, boolean after) {
        if (before && after) {
            throw new IllegalArgumentException("Point 전/후로 가로 라인이 존재할 수 없습니다.");
        }
    }

    public static Point of(boolean before, boolean after) {
        return new Point(before, after);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return before == point.before &&
                after == point.after;
    }

    @Override
    public int hashCode() {
        return Objects.hash(before, after);
    }

    @Override
    public String toString() {
        return convertLine(before) + "|";
    }

    private String convertLine(boolean target) {
        return target ? "-----" : "     ";
    }
}
