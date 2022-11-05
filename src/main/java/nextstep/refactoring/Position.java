package nextstep.refactoring;

import java.util.Objects;

public class Position {

    private final int index;
    private final Spot spot;

    public Position(int index, Spot spot) {
        this.spot = spot;
        this.index = index;
    }

    public static Position first(boolean yesNo) {
        return new Position(0, Spot.first(yesNo));
    }

    public Position next(boolean yesNo) {
        return new Position(this.index + 1, spot.right(yesNo));
    }

    public Position last() {
        return new Position(this.index + 1, spot.last());
    }

    public int move() {
        Direction direction = spot.move();
        return direction.moveDirection(index);
    }

    public Spot getSpot() {
        return spot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return index == position.index && Objects.equals(spot, position.spot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, spot);
    }
}
