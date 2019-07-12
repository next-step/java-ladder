package ladder.domain;

import java.util.Objects;

public class Position {
    private static final int MOVE_ONE_STEP_TO_RIGHT = 1;
    private static final int MOVE_ONE_STEP_TO_LEFT = -1;
    static final String ALERT_UNMOVABLE_TO_LEFT = "더 이상 왼쪽으로 이동할 수 없습니다.";
    private static final int FIRST_POSITION = 0;

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

    boolean unmovableToLeft() {
        return position <= FIRST_POSITION;
    }

    private void validationMovableToLeft() {
        if (unmovableToLeft()) {
            throw new IllegalArgumentException(ALERT_UNMOVABLE_TO_LEFT);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
