package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class JunctionNeighbors {

    private final Map<Direction, Junction> neighbors = new HashMap<>();

    public void setNeighbor(Direction direction, Junction junction) {
        neighbors.put(direction, junction);
    }

    public void setLeft(Junction junction) {
        setNeighbor(Direction.LEFT, junction);
    }

    public void setRight(Junction junction) {
        setNeighbor(Direction.RIGHT, junction);
    }

    public void setDown(Junction junction) {
        setNeighbor(Direction.DOWN, junction);
    }

    public Junction getNeighbor(Direction direction) {
        return neighbors.get(direction);
    }

    public boolean hasNeighbor(Direction direction) {
        return getNeighbor(direction) != null;
    }

    public boolean hasRight() {
        return hasNeighbor(Direction.RIGHT);
    }

    public boolean hasLeft() {
        return hasNeighbor(Direction.LEFT);
    }

    public boolean hasLeftOrRight() {
        return hasLeft() || hasRight();
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
