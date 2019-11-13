package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
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

    //TODO isLastIndex 대신 Point 객체를 파라미터로 받을 예정입니다.
    public static Direction getRandomDirection(Direction previousDirection, boolean isLastIndex) {
        if (Direction.RIGHT.equals(previousDirection)) {
            return Direction.LEFT;
        }

        if (isLastIndex) {
            return Direction.BOTTOM;
        }

        return getRandomDirection();
    }

    public static Direction getRandomDirection() {
        List<Direction> directions = Stream.of(Direction.values())
                .filter(value -> !Direction.LEFT.equals(value))
                .collect(Collectors.toList());

        Collections.shuffle(directions);
        return directions.get(0);
    }

    public int nextIndex(int index) {
        return this.moveIndex + index;
    }
}
