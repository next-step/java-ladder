package domain;

public enum Status {
    LEFT(true, false),
    RIGHT(false, true),
    FORWARD(false ,false);

    private final boolean left;
    private final boolean right;

    private Status(Boolean left, Boolean right) {
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
