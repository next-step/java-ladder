package ladder.domain;

import java.util.Objects;

public class Point {

    private final PositiveInt x;
    private final PositiveInt y;

    public Point(final int x, final int y) {
        this.x = new PositiveInt(x);
        this.y = new PositiveInt(y);
    }

    public Point(final PositiveInt x, final PositiveInt y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y.getValue();
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

        if (!this.x.equals(that.x)) {
            return false;
        }

        return this.y.equals(that.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.x, this.y);
    }
}
