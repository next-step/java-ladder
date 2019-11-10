package nextstep.ladder.domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Direction {
    LEFT(-1),
    RIGHT(1),
    BOTTOM(0);

    private int direction;

    Direction(int direction) {
        this.direction = direction;
    }

    public int getDirection() {
        return direction;
    }

    public static Direction getRandomDirection() {
        Random random = new Random(System.currentTimeMillis());
        List<Direction> directions = Stream.of(Direction.values())
                .filter(value -> !Direction.LEFT.equals(value))
                .collect(Collectors.toList());

        return directions.get(random.nextInt(directions.size()));
    }
}
