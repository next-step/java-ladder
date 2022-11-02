package ladder.domain.ladder;

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

    public static List<MoveHorizontalDirection> first() {
        return List.of(
                new MoveHorizontalDirection(HorizontalLineDirection.NONE, HorizontalLineDirection.NONE),
                new MoveHorizontalDirection(HorizontalLineDirection.NONE, HorizontalLineDirection.RIGHT));
    }

    public static MoveHorizontalDirection first(int number) {
        if ((number < 0) || (number >= first().size())) {
            throw new IllegalArgumentException();
        }
        return first().get(number);
    }

    public List<MoveHorizontalDirection> next() {
        if (this.currentHorizontalLineDirection.isRight()) {
            return List.of(
                    new MoveHorizontalDirection(this.currentHorizontalLineDirection, HorizontalLineDirection.LEFT));
        }
        return List.of(
                new MoveHorizontalDirection(this.currentHorizontalLineDirection, HorizontalLineDirection.NONE),
                new MoveHorizontalDirection(this.currentHorizontalLineDirection, HorizontalLineDirection.RIGHT));
    }

    public MoveHorizontalDirection last() {
        if (this.currentHorizontalLineDirection.isRight()) {
            return new MoveHorizontalDirection(this.currentHorizontalLineDirection, HorizontalLineDirection.LEFT);
        }
        return new MoveHorizontalDirection(this.currentHorizontalLineDirection, HorizontalLineDirection.NONE);
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
