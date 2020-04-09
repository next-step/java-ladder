package ladder.model.player;

import java.util.Arrays;

public enum Direction {
    LEFT (-1, true, false),
    RIGHT(1, false, true),
    STAY(0, false, false);

    private int increment;
    private boolean isNextLeftValueTrue;
    private boolean isNextRightValueTrue;

    Direction(int increment, boolean isNextLeftValueTrue, boolean isNextRightValueTrue) {
        this.increment = increment;
        this.isNextLeftValueTrue = isNextLeftValueTrue;
        this.isNextRightValueTrue = isNextRightValueTrue;
    }

    public static Direction findDirection(boolean isNextLeftValueTrue, boolean isNextRightValueTrue){
        return Arrays.stream(Direction.values())
                .filter(direction -> direction.isNextLeftValueTrue == isNextLeftValueTrue)
                .filter(direction -> direction.isNextRightValueTrue == isNextRightValueTrue)
                .findFirst()
                .orElse(Direction.STAY);
    }

    public int getIncrement() {
        return increment;
    }
}
