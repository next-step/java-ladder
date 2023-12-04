package nextstep.ladder.domain;

public class Point {
    private final int GOING_RIGHT = 1;
    private final int GOING_LEFT = -1;
    private final int HOLD_POSITION = 0;

    private final boolean leftConnected;
    private final boolean rightConnected;

    private Point(boolean leftConnected, boolean rightConnected) {
        this.leftConnected = leftConnected;
        this.rightConnected = rightConnected;
    }

    public static Point make(int index, int pointCount, StepFactory stepFactory) {
        if (index == 0) {
            return new Point(false, stepFactory.next());
        }
        if (index == pointCount - 1) {
            return new Point(stepFactory.previous(), false);
        }
        return new Point(stepFactory.previous(), stepFactory.next());
    }

    public int moving() {
        if (leftConnected) {
            return GOING_LEFT;
        }
        if (rightConnected) {
            return GOING_RIGHT;
        }
        return HOLD_POSITION;
    }

    public boolean isLeftConnected() {
        return leftConnected;
    }
}
