package ladder.domain.bridge;

import ladder.domain.bridge.direction.Direction;
import ladder.domain.common.Point;

import java.util.Collections;
import java.util.List;

public class Bridges {
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
}
