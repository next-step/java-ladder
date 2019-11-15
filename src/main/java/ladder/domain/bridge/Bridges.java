package ladder.domain.bridge;

import ladder.domain.bridge.direction.Direction;
import ladder.domain.common.Point;

import java.util.Collections;
import java.util.List;

public class Bridges {
    private static final int SYNC = 1;

    private final List<Bridge> bridges;

    public Bridges(List<Bridge> bridges) {
        this.bridges = bridges;
    }

    public List<Bridge> getBridges() {
        return Collections.unmodifiableList(bridges);
    }

    public int getHeight() {
        return this.bridges.stream()
                .map(Bridge::getY)
                .max(Integer::compareTo)
                .get();
    }

    public Direction findDirection(Point targetPoint) {
        return this.bridges.stream()
                .filter(bridge -> bridge.isSamePoint(targetPoint))
                .findFirst()
                .get()
                .getDirection();
    }

    public Point findDestinationPoint(Point point) {
        while (reachDestination(point)) {
            point = findNextPoint(point);
        }
        return point;
    }

    private Point findNextPoint(Point point) {
        Direction direction = findDirection(point);
        Point nextPoint = direction.move(point);
        return nextPoint;
    }

    private boolean reachDestination(Point point) {
        return point.getY() != getHeight() + SYNC;
    }
}
