package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.Objects;

public class Point {

    private final PointIndex pointIndex;
    private boolean hasPoint;

    public Point(boolean hasPoint, int left) {
        this.hasPoint = hasPoint;
        this.pointIndex = new PointIndex(left);
    }

    public void move(HashMap<Integer, Integer> map) {
        if (hasPoint) {
            pointIndex.swap(map);
        }
    }

    public boolean canMove() {
        return hasPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point point = (Point) o;
        return hasPoint == point.hasPoint && Objects.equals(pointIndex, point.pointIndex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pointIndex, hasPoint);
    }
}
