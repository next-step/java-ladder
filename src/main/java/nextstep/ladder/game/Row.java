package nextstep.ladder.game;

import nextstep.ladder.enums.Direction;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Row {
    private static final Random RANDOM = new Random();

    private final List<Direction> directions;

    public Row(List<Direction> directions) {
        this.directions = directions;
    }

    public static Row create(int width) {
        List<Direction> directions = new ArrayList<>();

        Direction firstDirection = createFirstDirection();
        directions.add(firstDirection);

        Direction previous = firstDirection;

        for (int i = 1; i < width - 1; i++) {
            Direction current = createCurrentDirection(previous);
            directions.add(current);
            previous = current;
        }

        Direction lastDirection = createdLastDirection(previous);
        directions.add(lastDirection);

        return new Row(directions);
    }

    private static Direction createFirstDirection() {
        if (RANDOM.nextBoolean()) {
            return Direction.RIGHT;
        }

        return Direction.CENTER;
    }

    private static Direction createdLastDirection(Direction previous) {
        if (previous == Direction.RIGHT) {
            return Direction.LEFT;
        }

        return Direction.CENTER;
    }

    private static Direction createCurrentDirection(Direction previous) {
        if (previous == Direction.RIGHT) {
            return Direction.LEFT;
        }

        if (RANDOM.nextBoolean()) {
            return Direction.RIGHT;
        }

        return Direction.CENTER;
    }

    public List<Direction> getDirections() {
        return directions;
    }
}
