package ladder.vo.coordinate;

import java.util.Objects;

public class Coordinate {
    private final CoordinateValue x;
    private final CoordinateValue y;

    public Coordinate(CoordinateValue x, CoordinateValue y) {
        this.x = x;
        this.y = y;
    }

    public CoordinateValue getX() {
        return x;
    }

    public CoordinateValue getY() {
        return y;
    }

    public int getXValue() {
        return x.getValue();
    }

    public int getYValue() {
        return y.getValue();
    }

    public Coordinate left() {
        return new Coordinate(this.x.decrement(), this.y);
    }

    public Coordinate right() {
        return new Coordinate(this.x.increment(), this.y);
    }

    public Coordinate down() {
        return new Coordinate(this.x, this.y.decrement());
    }

    public boolean canGoDown() {
        return CoordinateValue.MIN_COORDINATE_VALUE < getYValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return Objects.equals(x, that.x) &&
                Objects.equals(y, that.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return String.format("(%s, %s)", x, y);
    }
}
