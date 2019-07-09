package ladder.model;

public enum Direction {
    DOWN(Constants.DOWN_STEP),
    RIGHT(Constants.RIGHT_STEP),
    LEFT(Constants.LEFT_STEP);

    private final int step;

    Direction(int step) {
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
