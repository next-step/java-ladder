package ladder.model;

import java.util.Arrays;

public enum Direction {
    PASS(false, false),
    LEFT(true, false),
    RIGHT(false,true);

    private boolean left;
    private boolean current;

    Direction(boolean left, boolean current) {
        this.left = left;
        this.current = current;
    }

    public static Direction of(boolean left, boolean current) {
        return Arrays.stream(Direction.values())
                .filter(direction -> direction.left == left && direction.current == current)
                .findFirst().get();
    }

    public Position move(Position source) {
        if(this == LEFT) {
            return source.decrement();
        }

        if(this == RIGHT) {
            return source.increment();
        }

        return source;
    }
}
