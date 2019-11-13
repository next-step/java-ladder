package ladder.domain.bridge;

import ladder.domain.bridge.direction.Direction;
import ladder.domain.bridge.direction.WayGenerator;
import ladder.domain.common.Point;
import ladder.domain.common.Range;

import java.util.ArrayList;
import java.util.List;

public class BridgeFactory {

    private final WayGenerator wayGenerator;

    public BridgeFactory(WayGenerator wayGenerator) {
        this.wayGenerator = wayGenerator;
    }

    public Bridges makeBridges(Range range) {

        List<Bridge> bridges = new ArrayList<>();
        for (int y = 1; y <= range.getHeight(); y++) {
            Direction direction = Direction.getDirection(wayGenerator);

            bridges.add(makeFirstBridge(y, direction));
            bridges.addAll(makeMiddleBridges(Range.makeNowRange(range, y), direction));
            bridges.add(makeLastBridge(Range.makeNowRange(range, y), getMiddleLastDirection(bridges)));
        }

        return new Bridges(bridges);
    }

    private Direction getMiddleLastDirection(List<Bridge> bridges) {
        return bridges.get(bridges.size() - 1).getDirection();
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

    private Bridge makeFirstBridge(int y, Direction direction) {
        return new Bridge(new Point(0, y), direction);
    }

}
