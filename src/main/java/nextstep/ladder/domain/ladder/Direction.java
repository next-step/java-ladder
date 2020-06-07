package nextstep.ladder.domain.ladder;

public class Direction {

    public static final int LEFT = 0;
    public static final int RIGHT = 1;

    private final int direction;

    public Direction(int direction) {
        validate(direction);
        this.direction = direction;
    }

    public static Direction of(int direction) {
        return new Direction(direction);
    }

    private void validate(int direction) {
        if (direction != LEFT && direction != RIGHT) {
            throw new IllegalArgumentException(direction + " 은 잘못된 방향입니다.");
        }
    }
}
