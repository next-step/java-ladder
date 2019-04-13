package ladder.domain;

public enum DirectionType {
    LEFT(true, false),
    RIGHT(false, true),
    CENTER(false, false);

    private boolean left;
    private boolean right;

    DirectionType(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }
}
