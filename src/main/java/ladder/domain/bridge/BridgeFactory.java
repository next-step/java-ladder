package ladder.domain.bridge;

import ladder.domain.common.Point;
import ladder.domain.common.Range;

import java.util.ArrayList;
import java.util.List;

public class BridgeFactory {

    private final WayGenerator wayGenerator;

    public BridgeFactory(WayGenerator wayGenerator) {
        this.wayGenerator = wayGenerator;
    }

    public Bridges makeLadder(Range range) {
        Direction beforeDirection = Direction.getDirection(wayGenerator);

        List<Bridge> bridges = new ArrayList<>();
        for (int y = 1; y <= range.getHeight(); y++) {
            Direction direction = Direction.getDirection(wayGenerator);

            bridges.add(makeFirstBridge(y, direction));
            bridges.addAll(makeMiddleBridges(Range.makeNowRange(range, y), beforeDirection));
            bridges.add(makeLastBridge(Range.makeNowRange(range, y), beforeDirection));
        }

        return new Bridges(bridges);
    }

    private Bridge makeLastBridge(Range range, Direction beforeDirection) {
        Point point = new Point(range.getColRange() - 1, range.getHeight());
        Direction lastDirection = Direction.getLastDirection(beforeDirection);
        return new Bridge(point, lastDirection);
    }

    private List<Bridge> makeMiddleBridges(Range range, Direction beforeDirection) {
        List<Bridge> bridges = new ArrayList<>();
        for (int x = 1; x < range.getColRange() - 1; x++) {
            Point point = new Point(x, range.getHeight());
            beforeDirection = Direction.getMiddleDirection(wayGenerator, beforeDirection);
            Bridge bridge = new Bridge(point, beforeDirection);
            bridges.add(bridge);
        }
        return bridges;
    }

    private Direction makeMiddleDirection(Direction beforeDirection) {
        if (beforeDirection.equals(Direction.RIGHT)) {
            return Direction.LEFT;
        }
        return Direction.getDirection(wayGenerator);
    }

    private Bridge makeFirstBridge(int y, Direction direction) {
        return new Bridge(new Point(0, y), direction);
    }

}
