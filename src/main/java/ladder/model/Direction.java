package ladder.model;

public enum Direction {
    DOWN(false, false, Constants.DOWN_STEP),
    RIGHT(false, true, Constants.RIGHT_STEP),
    LEFT(true, false, Constants.LEFT_STEP);

    private final boolean left;
    private final boolean right;
    private final int step;

    Direction(boolean left, boolean right, int step) {
        this.left = left;
        this.right = right;
        this.step = step;
    }

    public int move(int position) {
        return position + step;
    }

    private static final class Constants {
        public static final int DOWN_STEP = 0;
        public static final int RIGHT_STEP = 1;
        public static final int LEFT_STEP = -1;
    }
}
