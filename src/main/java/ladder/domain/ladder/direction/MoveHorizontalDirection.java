package ladder.domain.ladder.direction;

import static ladder.domain.ladder.direction.HorizontalLineDirection.*;

import java.util.List;
import java.util.Objects;

public class MoveHorizontalDirection {

    private final HorizontalLineDirection currentHorizontalLineDirection;

    public MoveHorizontalDirection(HorizontalLineDirection currentHorizontalLineDirection) {
        this.currentHorizontalLineDirection = currentHorizontalLineDirection;
    }

    public static MoveHorizontalDirection first(int number) {
        if ((number < 0) || (number >= first().size())) {
            throw new IllegalArgumentException();
        }
        return first().get(number);
    }

    public static List<MoveHorizontalDirection> first() {
        return List.of(new MoveHorizontalDirection(NONE), new MoveHorizontalDirection(RIGHT));
    }

    public List<MoveHorizontalDirection> next() {
        if (this.currentHorizontalLineDirection.isRight()) {
            return List.of(new MoveHorizontalDirection(LEFT));
        }
        return List.of(new MoveHorizontalDirection(NONE),
                new MoveHorizontalDirection(RIGHT));
    }

    public MoveHorizontalDirection last() {
        if (this.currentHorizontalLineDirection.isRight()) {
            return new MoveHorizontalDirection(LEFT);
        }
        return new MoveHorizontalDirection(NONE);
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
        return currentHorizontalLineDirection == that.currentHorizontalLineDirection;
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentHorizontalLineDirection);
    }
}
