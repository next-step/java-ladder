package nextstep.ladder.domain.step;

import nextstep.ladder.domain.step.strategy.Movement;

import java.util.Objects;

public class Step {
    private static final int ONE = 1;

    private final Row row;
    private final boolean movable;

    private Step(Row row, boolean movable) {
        this.row = row;
        this.movable = movable;
    }

    public static Step of(Row row, Movement movement) {
        return new Step(row, movement.isMovable());
    }

    public int getPosition() {
        return row.getStepPosition();
    }

    public boolean isMovableLine(int linePosition) {
        return row.isEqaulLinePosition(linePosition) && movable;
    }

    public boolean isMovableNext(int linePosition) {
        return !(row.isEqaulLinePosition(linePosition + ONE) && movable);
    }

    public boolean isMovablePrev(int linePosition) {
        return row.isEqaulLinePosition(linePosition + ONE) && movable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Step step = (Step) o;
        return movable == step.movable &&
                Objects.equals(row, step.row);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movable, row);
    }
}
