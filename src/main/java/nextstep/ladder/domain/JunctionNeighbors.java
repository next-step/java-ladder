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
}
