package ladder.domain.second;

public enum Direction {
    RIGHT(1),
    LEFT(-1),
    PASS(0);

    private final int moveCount;

    Direction(int moveCount) {
        this.moveCount = moveCount;
    }

    public int moveCount() {
        return moveCount;
    }
}
