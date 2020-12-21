package nextstep.laddergame.domain;

public class Direction {
    private final int direction;

    private Direction(int direction) {
        this.direction = direction;
    }

    public static Direction from(int direction) {
        return new Direction(direction);
    }

    public boolean isRight() {
        return this.direction == 1;
    }

    public boolean isLeft() {
        return this.direction == -1;
    }

    public boolean isNotMove() {
        return this.direction == 0;
    }

    public int getDirection() {
        return direction;
    }
}
