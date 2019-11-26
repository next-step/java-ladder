package reladder.domain;

import java.util.HashMap;
import java.util.Map;

public enum Director {
    RIGHT(1),
    LEFT(-1),
    STAY(0);

    private static final Map<Direction, Director> DIRECTOR_MAP;

    static {
        DIRECTOR_MAP = new HashMap<>();
        DIRECTOR_MAP.put(Direction.of(false, true), RIGHT);
        DIRECTOR_MAP.put(Direction.of(true, false), LEFT);
        DIRECTOR_MAP.put(Direction.of(false, false), STAY);
    }

    private final int distance;

    Director(int distance) {
        this.distance = distance;
    }

    public static Director of(Direction direction) {
        return Director.DIRECTOR_MAP.get(direction);
    }

    public int move(int index) {
        return distance+index;
    }
}
