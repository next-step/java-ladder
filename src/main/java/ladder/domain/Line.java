package ladder.domain;

import java.util.Iterator;
import java.util.List;

public class Line implements Iterable<Boolean> { // 가로 축
    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public Direction getDirection(int currentLocation) {
        if (currentLocation == 0) {
            return new Direction(false, points.get(currentLocation));
        }

        if (currentLocation == points.size()) {
            return new Direction(points.get(currentLocation - 1), false);
        }

        return new Direction(points.get(currentLocation - 1), points.get(currentLocation));
    }

    @Override
    public Iterator<Boolean> iterator() {
        return points.iterator();
    }
}
