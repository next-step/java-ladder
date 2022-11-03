package ladder.domain.ladder.direction;

import java.util.List;

public enum HorizontalLineDirection {

    LEFT, STRAIGHT, RIGHT;

    public static HorizontalLineDirection first(int number) {
        if ((number < 0) || (number >= first().size())) {
            throw new IllegalArgumentException();
        }
        return first().get(number);
    }

    public static List<HorizontalLineDirection> first() {
        return List.of(STRAIGHT, RIGHT);
    }

    public List<HorizontalLineDirection> next() {
        if (this == RIGHT) {
            return List.of(LEFT);
        }
        return List.of(STRAIGHT, RIGHT);
    }

    public HorizontalLineDirection last() {
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
