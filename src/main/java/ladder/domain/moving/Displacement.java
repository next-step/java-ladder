package ladder.domain.moving;

public enum Displacement {
    LEFT(1, -1),
    RIGHT(1, 1),
    FORWARD(1, 0),
    STOP(0, 0);

    private final int vertical;
    private final int horizontal;

    Displacement(int vertical, int horizontal) {
        this.vertical = vertical;
        this.horizontal = horizontal;
    }

    public int vertical() {
        return vertical;
    }

    public int horizontal() {
        return horizontal;
    }

}
