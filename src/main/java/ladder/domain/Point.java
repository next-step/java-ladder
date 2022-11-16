package ladder.domain;

public enum Point {
    LEFT(-1),
    RIGHT(1),
    NONE(0);

    private final int movingValue;

    Point(int movingValue) {
        this.movingValue = movingValue;
    }

    public int getMovingValue() {
        return movingValue;
    }
}
