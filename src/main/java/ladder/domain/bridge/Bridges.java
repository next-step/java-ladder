package ladder.domain.bridge;

import ladder.domain.bridge.direction.Direction;
import ladder.domain.common.Point;
import ladder.domain.result.ResultPoint;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Bridges {
    private static final int SYNC = 1;
    private static final int STARTING_POINT = 1;

    private final List<Bridge> bridges;

    public Bridges(List<Bridge> bridges) {
        this.bridges = bridges;
    }

    public List<Bridge> getBridges() {
        return Collections.unmodifiableList(bridges);
    }

    public int getWidth() {
        return bridges.stream()
                .map(Bridge::getX)
                .max(Integer::compareTo)
                .orElseThrow(IllegalAccessError::new);
    }

    public int getHeight() {
        return this.bridges.stream()
                .map(Bridge::getY)
                .max(Integer::compareTo)
                .orElseThrow(IllegalAccessError::new);
    }

    public Direction findDirection(Point targetPoint) {
        return this.bridges.stream()
                .filter(bridge -> bridge.isSamePoint(targetPoint))
                .findFirst()
                .map(Bridge::getDirection)
                .orElseThrow(IllegalAccessError::new);
    }

    private Point findDestinationPoint(Point point) {
        while (reachDestination(point)) {
            point = findNextPoint(point);
        }
        return point;
    }

    public List<ResultPoint> makeResultPoints() {
        return IntStream.rangeClosed(0, getWidth())
                .mapToObj(this::makeResultPoint)
                .collect(Collectors.toList());
    }

    private ResultPoint makeResultPoint(int x) {
        Point destinationPoint = findDestinationPoint(new Point(x, STARTING_POINT));
        return new ResultPoint(x, destinationPoint.getX());
    }

    private Point findNextPoint(Point point) {
        Direction direction = findDirection(point);
        return direction.move(point);
    }

    private boolean reachDestination(Point point) {
        return point.getY() != getHeight() + SYNC;
    }
}
