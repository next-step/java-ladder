package nextstep.laddergame.service;

public enum PositionDirection {
    RIGHT(1),
    LEFT(-1);

    private final int value;

    PositionDirection(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
