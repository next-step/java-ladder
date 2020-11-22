package ladder.domain.model;

public enum Direction {
    LEFT(-1),
    DOWN(0),
    RIGHT(1);

    private final int move;

    Direction(int move) {
        this.move = move;
    }

    int getMove() {
        return move;
    }
}
