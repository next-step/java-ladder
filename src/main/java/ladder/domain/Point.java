package ladder.domain;

public enum Point {
    LEFT(-1),
    RIGHT(1),
    STOP(0);

    private final int move;

    Point(int move) {
        this.move = move;
    }

    public int getMove() {
        return move;
    }
}
