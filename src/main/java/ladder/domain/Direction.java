package ladder.domain;

public enum Direction {
    LEFT(-1),
    RIGHT(1),
    DONT(0);

    private final int move;

    Direction(int move) {
        this.move = move;
    }

    public int move() {
        return move;
    }


}
