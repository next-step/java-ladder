package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Direction {
    LEFT(-1),
    RIGHT(1),
    BOTTOM(0);

    private int moveIndex;

    Direction(int moveIndex) {
        this.moveIndex = moveIndex;
    }

    public static Direction getRandomDirection(Optional<Direction> previousDirection) {
        return previousDirection
                .filter(Direction.RIGHT::equals)
                .map(direction -> Direction.LEFT)
                .orElse(getRandomDirection());
    }

    public static Direction getRandomDirection() {
        List<Direction> directions = Stream.of(Direction.values())
                .filter(value -> !Direction.LEFT.equals(value))
                .collect(Collectors.toList());

        Collections.shuffle(directions);
        return directions.get(0);
    }
}
