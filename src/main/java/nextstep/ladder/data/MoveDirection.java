package nextstep.ladder.data;

public enum MoveDirection {
    LEFT(-1),
    STAY(0),
    RIGHT(1)
    ;

    private final int direction;

    MoveDirection(int direction) {
        this.direction = direction;
    }

    public int getDirection() {
        return this.direction;
    }
}
