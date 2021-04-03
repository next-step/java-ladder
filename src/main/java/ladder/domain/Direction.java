package ladder.domain;

public enum Direction {
    LEFT(-1),
    STAY(0),
    LIGHT(1);

    private final int direction;

    Direction(int direction) {
        this.direction = direction;
    }

    public int direction() {
        return direction;
    }
}
