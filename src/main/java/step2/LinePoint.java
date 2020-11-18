package step2;

import java.util.Objects;

public class LinePoint {
    private final int x;
    private final int y;

    public LinePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinePoint linePoint = (LinePoint) o;
        return x == linePoint.x &&
                y == linePoint.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
