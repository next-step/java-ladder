package ladder.domain.point;

import ladder.domain.strategy.PointStrategy;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Direction {
    GO(false, true, 1),
    BACK(true, false, -1),
    STAY(false, false, 0);

    public static final String INVALID_DIRECTION_MESSAGE = "잘못된 방향입니다.";

    private final boolean left;
    private final boolean current;
    private final int movePoint;

    Direction(boolean left, boolean current, int movePoint) {
        if (left && current) {
            throw new IllegalArgumentException(INVALID_DIRECTION_MESSAGE);
        }

        this.left = left;
        this.current = current;
        this.movePoint = movePoint;
    }

    private static final Map<String, Direction> directions = Collections.unmodifiableMap(Arrays.stream(values())
            .collect(Collectors.toMap(direction -> toKey(direction.left, direction.current), Function.identity())));

    public static Direction first(PointStrategy pointStrategy) {
        return of(false, pointStrategy.next());
    }

    public Direction next(PointStrategy pointStrategy) {
        if (this.current) {
            return next(false);
        }

        return next(pointStrategy.next());
    }

    private Direction next(boolean next) {
        return of(current, next);
    }

    public Direction last() {
        return of(current, false);
    }

    public int move() {
        return movePoint;
    }

    public static Direction of(boolean left, boolean current) {
        return Optional.ofNullable(directions.get(toKey(left, current)))
                .orElseThrow(() -> new IllegalArgumentException(INVALID_DIRECTION_MESSAGE));
    }

    private static String toKey(boolean left, boolean current) {
        return String.format("%s %s", left, current);
    }

    public boolean isLeft() {
        return left;
    }
}
