package ladder.domain;

import java.util.HashMap;
import java.util.Map;

public enum MovingOperator {

    RIGHT(1),
    STAY(0),
    LEFT(-1);

    private final static Map<Moving, MovingOperator> FINDER;

    private int position;

    static {
        FINDER = new HashMap<>();
        FINDER.put(Moving.right(), RIGHT);
        FINDER.put(Moving.stay(), STAY);
        FINDER.put(Moving.left(), LEFT);
    }

    MovingOperator(int position) {
        this.position = position;
    }

    public static int getPosition(Moving moving) {
        return FINDER.get(moving).position;
    }
}
