package nextstep.step2.domain;

import java.util.Map;
import java.util.Objects;

public class Directions {
    private final Map<Direction, Boolean> directions;

    public Directions(Map<Direction, Boolean> directions) {
        this.directions = directions;
    }

    public static Directions createFirst(PointCreationStrategy strategy) {
        return new Directions(Map.of(Direction.LEFT, false, Direction.RIGHT, strategy.isCreation()));
    }

    public static Directions createNext(PointCreationStrategy strategy, boolean left) {
        return new Directions(Map.of(Direction.LEFT, left, Direction.RIGHT, isRight(strategy, left)));
    }

    public static Directions createLast(boolean left) {
        return new Directions(Map.of(Direction.LEFT, left, Direction.RIGHT, false));
    }

    public boolean isLeftLine() {
        return directions.get(Direction.LEFT);
    }

    public boolean isRightLine() {
        return directions.get(Direction.RIGHT);
    }

    public int move(final int index) {
        if (this.isLeftLine()) {
            return Direction.moveLeft(index);
        }

        if (this.isRightLine()) {
            return Direction.moveRight(index);
        }

        return Direction.moveDown(index);
    }

    private static boolean isRight(final PointCreationStrategy strategy, final boolean left) {
        if (left) {
            return false;
        }

        return strategy.isCreation();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        Directions that = (Directions) o;
        return Objects.equals(directions, that.directions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(directions);
    }
}
