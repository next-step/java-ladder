package ladder.domain.direction;

import java.util.function.Function;
import ladder.domain.Position;

public enum  Direction {

    LEFT(Position::decreasePosition),
    RIGHT(Position::increasePosition),
    DOWN(Position::keepPosition);

    private final Function<Position, Position> computeNextPosition;

    Direction(Function<Position, Position> computeNextPosition) {
        this.computeNextPosition = computeNextPosition;
    }

    public Position getNextPosition(Position Position) {
        return computeNextPosition.apply(Position);
    }
}
