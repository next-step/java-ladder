package ladder.domain;

public class Position {

    private static final int MOVE_ONE_STEP_TO_RIGHT = 1;
    private static final int MOVE_ONE_STEP_TO_LEFT = -1;
    private int position;

    private Position(int currentPosition) {
        this.position = currentPosition;
    }

    public static Position from(int currentPosition) {
        return new Position(currentPosition);
    }

    public boolean isSameWith(int targetPosition) {
        return position == targetPosition;
    }

    Position moveToRight() {
        return from(this.position + MOVE_ONE_STEP_TO_RIGHT);
    }

    Position moveToLeft() {
        return from(this.position + MOVE_ONE_STEP_TO_LEFT);
    }

    int getPosition() {
        return position;
    }

    int getLeftPosition() {
        return this.position + MOVE_ONE_STEP_TO_LEFT;
    }
}
