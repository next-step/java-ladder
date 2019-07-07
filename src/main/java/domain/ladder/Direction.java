package domain.ladder;

public enum Direction {
    LEFT(-1),
    RIGHT(1),
    FORWARD(0);

    private int move;

    Direction(int move) {
        this.move = move;
    }

    public static int move(Pair pair, int current) {
        if (pair.isLeft()) return current + LEFT.move;
        if (pair.isRight()) return current + RIGHT.move;
        return current + FORWARD.move;
    }
}
