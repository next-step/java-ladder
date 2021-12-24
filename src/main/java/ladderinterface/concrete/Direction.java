package ladderinterface.concrete;

public class Direction {
    private final boolean prev;
    private final boolean current;

    private Direction(boolean prev, boolean current) {
        this.prev = prev;
        this.current = current;
    }

    public static Direction of(boolean prev, boolean current) {
        return new Direction(prev, current);
    }

    public static Direction first(boolean current) {
        return new Direction(false, current);
    }

}
