package ladder.domain;

public enum Direction {
    LEFT(-1),
    RIGHT(1),
    NONE(0);

    private int move;

    Direction(int move) {
        this.move = move;
    }

    public int next(int currentPosition) {
        return currentPosition + this.move;
    }
}
