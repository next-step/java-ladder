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

    public static Direction firstOf(ConnectorStrategy connector) {
        return connector.isConnectedToRight() ? RIGHT : DOWN;
    }

    public Direction nextOf(ConnectorStrategy connector) {
        if (this == RIGHT) {
            return LEFT;
        }

        return connector.isConnectedToRight() ? RIGHT : DOWN;
    }

    public Direction endOf() {
        return this == RIGHT ? LEFT : DOWN;
    }

    private static final class Constants {
        public static final int DOWN_STEP = 0;
        public static final int RIGHT_STEP = 1;
        public static final int LEFT_STEP = -1;
    }
}
