package ladder.domain.ladder;

import ladder.domain.result.Movement;

import java.util.Objects;

public class Point {
    private final boolean left;
    private final boolean right;

    private Point(boolean left, boolean right) {
        isNotBothTrue(left, right);
        this.left = left;
        this.right = right;
    }

    private void isNotBothTrue(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("Point 전/후로 가로 라인이 존재할 수 없습니다.");
        }
    }

    public static Point of(boolean left, boolean right) {
        return new Point(left, right);
    }

    public Movement move() {
        return Movement.valueBy(left, right);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return left == point.left &&
                right == point.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }

    @Override
    public String toString() {
        return convertLine(left) + "|";
    }

    private String convertLine(boolean target) {
        return target ? "-----" : "     ";
    }
}
