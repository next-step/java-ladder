package nextstep.ladder;

import nextstep.ladder.random.RandomGenerator;

import static nextstep.ladder.ui.ResultView.EMPTY_SPACE;
import static nextstep.ladder.ui.ResultView.HORIZONTAL_LINE;

public enum Direction {

    LEFT(-1, EMPTY_SPACE),
    RIGHT(1, HORIZONTAL_LINE),
    STRAIGHT(0, EMPTY_SPACE);

    private final int value;
    private final String display;

    Direction(int value, String display) {
        this.value = value;
        this.display = display;
    }

    public int getValue() {
        return value;
    }

    public static Direction of(Direction before, boolean isLast) {
        if (RIGHT.equals(before)) {
            return LEFT;
        }

        if (isLast) {
            return STRAIGHT;
        }

        return generate(RandomGenerator.generate());
    }

    @Override
    public String toString() {
        return display;
    }

    private static Direction generate(boolean right) {
        if (right) {
            return RIGHT;
        }
        return STRAIGHT;
    }
}
