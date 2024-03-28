package ladder2.domain;

import java.util.function.Function;

public enum Link {

    LEFT_LINK(Position::minus),
    RIGHT_LINK(Position::plus),
    NO_LINK(position -> position);

    private final Function<Position, Position> nextPositionFunction;

    Link(Function<Position, Position> nextPositionFunction) {
        this.nextPositionFunction = nextPositionFunction;
    }

    public Position nextPosition(Position position) {
        return nextPositionFunction.apply(position);
    }
}
