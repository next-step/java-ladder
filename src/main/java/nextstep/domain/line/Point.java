package nextstep.domain.line;

import nextstep.generator.PointGenerator;

import java.util.Objects;

public class Point {
    private final boolean isConnected;

    public Point(PointGenerator pointGenerator) {
        this.isConnected = pointGenerator.generate();
    }

    public Point(boolean point) {
        this.isConnected = point;
    }

    public boolean isConnected() {
        return isConnected;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Point point = (Point) object;
        return point.isConnected == this.isConnected;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(isConnected);
    }
}
