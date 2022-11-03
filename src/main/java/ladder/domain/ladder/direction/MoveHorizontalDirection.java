package ladder.domain.ladder.direction;

import java.util.List;
import java.util.Objects;

public class MoveHorizontalDirection {

    private final HorizontalLineDirection beforeHorizontalLineDirection;
    private final HorizontalLineDirection currentHorizontalLineDirection;

    public MoveHorizontalDirection(HorizontalLineDirection beforeHorizontalLineDirection,
                                   HorizontalLineDirection currentHorizontalLineDirection) {
        this.beforeHorizontalLineDirection = beforeHorizontalLineDirection;
        this.currentHorizontalLineDirection = currentHorizontalLineDirection;
    }

    public static MoveHorizontalDirection first(int number) {
        if ((number < 0) || (number >= first().size())) {
            throw new IllegalArgumentException();
        }
        return first().get(number);
    }

    public static List<MoveHorizontalDirection> first() {
        return List.of(new MoveHorizontalDirection(HorizontalLineDirection.NONE, HorizontalLineDirection.NONE),
                new MoveHorizontalDirection(HorizontalLineDirection.NONE, HorizontalLineDirection.RIGHT));
    }

    public List<MoveHorizontalDirection> next() {
        if (this.currentHorizontalLineDirection.isRight()) {
            return List.of(current(HorizontalLineDirection.LEFT));
        }
        return List.of(current(HorizontalLineDirection.NONE), current(HorizontalLineDirection.RIGHT));
    }

    public MoveHorizontalDirection last() {
        if (this.currentHorizontalLineDirection.isRight()) {
            return current(HorizontalLineDirection.LEFT);
        }
        return current(HorizontalLineDirection.NONE);
    }

    private MoveHorizontalDirection current(HorizontalLineDirection horizontalLineDirection) {
        return new MoveHorizontalDirection(this.currentHorizontalLineDirection, horizontalLineDirection);
    }

    public boolean isCurrentRight() {
        return this.currentHorizontalLineDirection == HorizontalLineDirection.RIGHT;
    }

    public boolean isCurrentLeft() {
        return this.currentHorizontalLineDirection == HorizontalLineDirection.LEFT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MoveHorizontalDirection that = (MoveHorizontalDirection) o;
        return beforeHorizontalLineDirection == that.beforeHorizontalLineDirection
                && currentHorizontalLineDirection == that.currentHorizontalLineDirection;
    }

    @Override
    public int hashCode() {
        return Objects.hash(beforeHorizontalLineDirection, currentHorizontalLineDirection);
    }
}
