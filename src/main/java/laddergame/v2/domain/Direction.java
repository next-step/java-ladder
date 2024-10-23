package laddergame.v2.domain;

public enum Direction {
    LEFT(-1), RIGHT(1), DOWN(0);

    private final int offset;

    Direction(int offset) {
        this.offset = offset;
    }

    public int getOffset() {
        return offset;
    }
}
