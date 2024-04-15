package ladder.domain.ladder.line;

public enum Direction {

    LEFT(-1),
    RIGHT(1),
    DOWN(0);

    private final int delta;

    Direction(final int delta) {
        this.delta = delta;
    }

    public int delta() {
        return this.delta;
    }
}
