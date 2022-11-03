package ladder.domain.ladder.direction;

import static ladder.domain.ladder.direction.HorizontalLineDirection.*;

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
        return List.of(new MoveHorizontalDirection(NONE, NONE), new MoveHorizontalDirection(NONE, RIGHT));
    }

    public List<MoveHorizontalDirection> next() {
        if (this.currentHorizontalLineDirection.isRight()) {
            return List.of(new MoveHorizontalDirection(this.currentHorizontalLineDirection, LEFT));
        }
        return List.of(new MoveHorizontalDirection(this.currentHorizontalLineDirection, NONE),
                new MoveHorizontalDirection(this.currentHorizontalLineDirection, RIGHT));
    }

    public MoveHorizontalDirection last() {
        if (this.currentHorizontalLineDirection.isRight()) {
            return new MoveHorizontalDirection(this.currentHorizontalLineDirection, LEFT);
        }
        return new MoveHorizontalDirection(this.currentHorizontalLineDirection, NONE);
    }

    public boolean isCurrentRight() {
        return this.currentHorizontalLineDirection == RIGHT;
    }

    public boolean isCurrentLeft() {
        return this.currentHorizontalLineDirection == LEFT;
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
