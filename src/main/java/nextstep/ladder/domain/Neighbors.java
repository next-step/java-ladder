package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class Neighbors {

    private final Map<Direction, Junction> neighbors = new HashMap<>();

    public void setLeft(Junction junction) {
        neighbors.put(Direction.LEFT, junction);
    }

    public void setRight(Junction junction) {
        neighbors.put(Direction.RIGHT, junction);
    }

    public void setDown(Junction junction) {
        neighbors.put(Direction.DOWN, junction);
    }

    public Junction getLeft() {
        return neighbors.get(Direction.LEFT);
    }

    public Junction getRight() {
        return neighbors.get(Direction.RIGHT);
    }

    public Junction getDown() {
        return neighbors.get(Direction.DOWN);
    }

}
