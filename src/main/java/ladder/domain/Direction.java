package ladder.domain;

public enum Direction {

    LEFT(true, false),
    RIGHT(false, true),
    PASS(false, false);

    private static final String ALERT_ADJACENT_LINES = "가로 라인은 겹칠 수 없습니다.";
    private boolean left;
    private boolean right;

    Direction(boolean left, boolean right) {
        validationDirection(left, right);
        this.left = left;
        this.right = right;
    }

    public boolean isRight() {
        return right;
    }

    public Position move(Position position) {
        if (left && !right) {
            return position.moveToLeft();
        }
        if (!left && right) {
            return position.moveToRight();
        }
        return position;
    }

    private void validationDirection(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException(ALERT_ADJACENT_LINES);
        }
    }
}
