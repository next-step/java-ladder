package ladder.domain.ladder.direction;

import java.util.List;

public enum MoveHorizontalDirection {

    LEFT, STRAIGHT, RIGHT;

    public static MoveHorizontalDirection first(int number) {
        if ((number < 0) || (number >= first().size())) {
            throw new IllegalArgumentException();
        }
        return first().get(number);
    }

    public static List<MoveHorizontalDirection> first() {
        return List.of(STRAIGHT, RIGHT);
    }

    public List<MoveHorizontalDirection> next() {
        if (this == RIGHT) {
            return List.of(LEFT);
        }
        return List.of(STRAIGHT, RIGHT);
    }

    public MoveHorizontalDirection last() {
        if (this == RIGHT) {
            return LEFT;
        }
        return STRAIGHT;
    }

    public boolean isRight() {
        return this == RIGHT;
    }

    public boolean isLeft() {
        return this == LEFT;
    }
}
