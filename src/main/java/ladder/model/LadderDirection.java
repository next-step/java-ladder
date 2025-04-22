package ladder.model;

public enum LadderDirection {
    LEFT(-1),
    RIGHT(1),
    STAY(0);

    private final int offset;

    LadderDirection(int offset) {
        this.offset = offset;
    }

    public int getOffset() {
        return offset;
    }
}
