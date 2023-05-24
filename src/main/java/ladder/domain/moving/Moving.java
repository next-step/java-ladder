package ladder.domain.moving;

public enum Moving {
    LEFT(1, -1, Boolean.TRUE, Boolean.FALSE),
    RIGHT(1, 1, Boolean.FALSE, Boolean.TRUE),
    FORWARD(1, 0, Boolean.FALSE, Boolean.FALSE),
    STOP(0, 0, null, null);

    private final int vertical;
    private final int horizontal;
    private final Boolean left;
    private final Boolean right;

    Moving(int vertical, int horizontal, Boolean left, Boolean right) {
        this.vertical = vertical;
        this.horizontal = horizontal;
        this.left = left;
        this.right = right;
    }

    public int vertical() {
        return vertical;
    }

    public int horizontal() {
        return horizontal;
    }

    public Boolean left() {
        return left;
    }

    public Boolean right() {
        return right;
    }

}
