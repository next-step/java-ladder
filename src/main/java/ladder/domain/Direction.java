package ladder.domain;

public enum Direction {
    LEFT(-1),
    RIGHT(1),
    NONE(0);

    private int move;

    Direction(int move) {
        this.move = move;
    }

    public int nextIndex(int currentIndex) {
        return currentIndex + this.move;
    }
}
