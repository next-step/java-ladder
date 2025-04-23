package nextstep.ladder.domain;

public enum Direction {
    LEFT(-1),
    RIGHT(1),
    STAY(0);

    private final int offset;

    Direction(int offset) {
        this.offset = offset;
    }

    public int move(int index) {
        return index + offset;
    }
}
