package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class JunctionNeighbors {

    private final Map<Direction, Junction> neighbors = new HashMap<>();

    public void setNeighbor(Direction direction, Junction junction) {
        neighbors.put(direction, junction);
    }

    public Junction getNeighbor(Direction direction) {
        return neighbors.get(direction);
    }

    public boolean hasNeighbor(Direction direction) {
        return getNeighbor(direction) != null;
    }

    public boolean hasDown() {
        return hasNeighbor(Direction.DOWN);
    }

    public void connectRight(Junction left, Junction right) {
        left.setRight(right);
        right.setLeft(left);
    }

    public void connectDown(Junction up, Junction down) {
        up.setDown(down);
    }
}
