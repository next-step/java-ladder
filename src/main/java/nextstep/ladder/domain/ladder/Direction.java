package nextstep.ladder.domain.ladder;

import java.util.Collections;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Direction {

    LEFT(-1),
    RIGHT(1),
    DOWN(0);

    private static final Map<Integer, Direction> directionMap;

    static {
        directionMap = Collections.unmodifiableMap(
                Stream.of(Direction.values())
                        .collect(Collectors.toMap(Direction::getDirection, direction -> direction))
        );
    }

    private final int direction;

    Direction(int direction) {
        this.direction = direction;
    }

    public static Direction of(int direction) {
        return directionMap.get(direction);
    }

    public int getDirection() {
        return direction;
    }

    public Direction next(DirectionPredicate predicate) {
        return this == RIGHT ? LEFT : generate(predicate);
    }
    private static Direction generate(DirectionPredicate predicate) {
        return predicate.test() ? RIGHT : DOWN;
    }
}
