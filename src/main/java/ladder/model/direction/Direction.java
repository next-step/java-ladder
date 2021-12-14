package ladder.model.direction;

import java.util.HashMap;
import java.util.Map;

public class Direction {

    private static final DirectionKey directionKey = new DirectionKey();
    private static final Map<Integer,Direction> DIRECTION_CACHE = new HashMap<>();
    private final boolean right;
    private final boolean left;

    static {
        DIRECTION_CACHE.put(1, new Direction(false, false));
        DIRECTION_CACHE.put(2, new Direction(false, true));
        DIRECTION_CACHE.put(3, new Direction(true, false));
    }

    private Direction(boolean left, boolean right) {
        this.right = right;
        this.left = left;
    }

    public static Direction of(boolean left, boolean right) {
        return DIRECTION_CACHE.get(directionKey.get(left,right));
    }

    public static Direction first(boolean right) {
        return of(false,right);
    }

    public Direction last() {
        return of(this.left, false);
    }

    public Direction next(boolean randomRight) {
        if(this.right) {
            return of(true, false);
        }
        return of(false, randomRight);
    }

    public boolean left() {
        return this.left;
    }

    public boolean right() {
        return this.right;
    }
}
