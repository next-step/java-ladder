package ladder.domain;

public enum Direction {

    LEFT(true, false),
    RIGHT(false, true),
    PASS(false, false);

    private boolean left;
    private boolean right;

    Direction(boolean left, boolean right) {
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
}
