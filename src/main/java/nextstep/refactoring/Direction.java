package nextstep.refactoring;

public enum Direction {
    LEFT(-1),
    RIGHT(1),
    PASS(0),
    ;

    private final int direction;

    Direction(int direction) {
        this.direction = direction;
    }

    public int moveDirection(int index) {
        return index + this.direction;
    }
}
