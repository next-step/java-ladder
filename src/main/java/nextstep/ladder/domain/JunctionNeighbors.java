package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class JunctionNeighbors {

    private final Map<Direction, Junction> neighbors = new HashMap<>();

    public void setByDirection(Direction direction, Junction junction) {
        neighbors.put(direction, junction);
    }

    public void setLeft(Junction junction) {
        setByDirection(Direction.LEFT, junction);
    }

    public void setRight(Junction junction) {
        setByDirection(Direction.RIGHT, junction);
    }

    public void setDown(Junction junction) {
        setByDirection(Direction.DOWN, junction);
    }

    public Junction getByDirection(Direction direction) {
        return neighbors.get(direction);
    }

    public boolean hasByDirection(Direction direction) {
        return getByDirection(direction) != null;
    }

    public boolean hasRight() {
        return hasByDirection(Direction.RIGHT);
    }

    public boolean hasLeft() {
        return hasByDirection(Direction.LEFT);
    }

    public boolean hasLeftOrRight() {
        return hasLeft() || hasRight();
    }

    public boolean hasDown() {
        return hasByDirection(Direction.DOWN);
    }

    public void connectRight(Junction left, Junction right) {
        left.setRight(right);
        right.setLeft(left);
    }

    public void connectDown(Junction up, Junction down) {
        up.setDown(down);
    }
}
