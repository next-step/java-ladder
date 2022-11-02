package ladder.domain;

import java.util.Objects;

public class Point {

    private final static String ERROR_NEGATIVE_VALUE = "0 이상의 값만 입력 가능합니다.";

    private final int x;
    private final int y;
    private boolean isLocatedLine;

    public Point(final int x, final int y) {
        validate(x);
        validate(y);

        this.x = x;
        this.y = y;
        this.isLocatedLine = false;
    }

    private void validate(final int value) {
        if (value < 0) {
            throw new IllegalArgumentException(ERROR_NEGATIVE_VALUE);
        }
    }

    public boolean isLocatedLine() {
        return isLocatedLine;
    }

    public void setLine() {
        this.isLocatedLine = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Point)) {
            return false;
        }

        Point that = (Point) o;

        if (this.x != that.x) {
            return false;
        }

        return this.y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.x, this.y);
    }
}
