package nextstep.ladder.game;

import nextstep.ladder.enums.Direction;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderFactory {
    private static final Random RANDOM = new Random();

    private LadderFactory() {
    }

    public static Ladder createLadder(int width, int height) {
        List<Row> rows = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            rows.add(createRow(width));
        }
        return new Ladder(rows);
    }

    private static Row createRow(int width) {
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
}
