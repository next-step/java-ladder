package ladder.domain;

public class Position {

    private static final int MOVE_ONE_STEP_TO_RIGHT = 1;
    private static final int MOVE_ONE_STEP_TO_LEFT = -1;
    static final String ALERT_UNMOVABLE_TO_LEFT = "더 이상 왼쪽으로 이동할 수 없습니다.";
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
        validationMovableToLeft();
        return from(this.position + MOVE_ONE_STEP_TO_LEFT);
    }

    int getPosition() {
        return position;
    }

    int getLeftPosition() {
        validationMovableToLeft();
        return this.position + MOVE_ONE_STEP_TO_LEFT;
    }

    private void validationMovableToLeft() {
        if (unmovableToLeft()) {
            throw new IllegalArgumentException(ALERT_UNMOVABLE_TO_LEFT);
        }
    }

    private boolean unmovableToLeft() {
        return position <= 0;
    }
}
