package step3;

import step3.strategy.LeftMove;
import step3.strategy.NoMove;
import step3.strategy.RightMove;
import step3.strategy.SideMoveStrategy;

import java.util.Objects;

public class Position {
    private final static int OFFSET_LEFT = -1;
    private final static int OFFSET_RIGHT = 0;

    private final static int OFFSET_LEFT_PROGRESS = -1;
    private final static int OFFSET_RIGHT_PROGRESS = 1;

    private final int value;

    public Position(int value) {
        this.value = value;
    }

    public SideMoveStrategy getMoveDirection(Line line) {
        if (line.hasSidelineAt(value + OFFSET_LEFT)) {
            return new LeftMove();
        }

        if (line.hasSidelineAt(value + OFFSET_RIGHT)) {
            return new RightMove();
        }

        return new NoMove();
    }

    public Position just() {
        return new Position(this.value);
    }

    public Position toLeft() {
        return new Position(this.value + OFFSET_LEFT_PROGRESS);
    }

    public Position toRight() {
        return new Position(this.value + OFFSET_RIGHT_PROGRESS);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
