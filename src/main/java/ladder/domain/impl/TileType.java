package ladder.domain.impl;

public enum TileType {

    RIGHT(1), LEFT(-1), DOWN(0);

    private final int move;

    TileType(int move) {
        this.move = move;
    }

    public static TileType first(boolean isRight) {
        return rightOrDown(isRight);
    }

    public TileType next(boolean isRight) {
        if (this == RIGHT) {
            return LEFT;
        }
        return rightOrDown(isRight);
    }

    public TileType last() {
        if (this == RIGHT) {
            return LEFT;
        }
        return DOWN;
    }

    private static TileType rightOrDown(boolean isRight) {
        if (isRight) {
            return RIGHT;
        }
        return DOWN;
    }

    public int move() {
        return move;
    }
}
