package ladder.domain.point;

import ladder.domain.strategy.PointStrategy;

public class Direction {
    private final boolean left;
    private final boolean current;

    private Direction(boolean left, boolean current) {
        this.left = left;
        this.current = current;
    }

    public static Direction first(PointStrategy pointStrategy) {
        return new Direction(false, pointStrategy.next());
    }

    public Direction next(PointStrategy pointStrategy) {
        if (this.current) {
            return new Direction(true, false);
        }

        return new Direction(false, pointStrategy.next());
    }

    public Direction last() {
        return new Direction(this.current, false);
    }

    public int move() {
        if (this.left) {
            return -1;
        }

        if (this.current) {
            return +1;
        }

        return 0;
    }
}
