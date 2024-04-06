package laddergame.domain.ladder;

public enum Direction {
    LEFT(-1),
    RIGHT(1),
    DOWN(0);

    private final int value;

    Direction(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
