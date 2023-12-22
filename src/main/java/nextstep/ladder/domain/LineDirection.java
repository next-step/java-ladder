package nextstep.ladder.domain;

import java.util.Random;

public enum LineDirection {

    STRAIGHT,
    RIGHT,
    LEFT;

    private static final Random random = new Random();

    LineDirection() {
    }

    public static void validateSequentialDirection(LineDirection left, LineDirection right) {
        if (left.equals(RIGHT) && right.equals(RIGHT)) {
            throw new IllegalArgumentException("라인은 연속으로 겹치면 안됩니다.");
        }

        if (left.equals(LEFT) && right.equals(LEFT)) {
            throw new IllegalArgumentException("라인은 연속으로 겹치면 안됩니다.");
        }
    }

    public static LineDirection makeRandomDirection(LineDirection leftDirection) {
        if (leftDirection.equals(RIGHT)) {
            return LEFT;
        }
        LineDirection[] directions = {STRAIGHT, RIGHT};
        return directions[random.nextInt(directions.length)];
    }

    public static LineDirection makeFirstRandomDirection() {
        LineDirection[] directions = {STRAIGHT, RIGHT};
        return directions[random.nextInt(directions.length)];
    }

    public static LineDirection makeLastDirection(LineDirection left) {
        if (left.equals(RIGHT)) {
            return LEFT;
        }
        return STRAIGHT;
    }
}
