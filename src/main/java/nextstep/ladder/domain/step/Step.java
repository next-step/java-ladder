package nextstep.ladder.domain.step;

import nextstep.ladder.domain.step.strategy.Movement;

import java.util.Objects;

public class Step {
    private final Row row;
    private final boolean movable;

    private Step(boolean movable) {
        this(null, movable);
    }

    private Step(Row row, boolean movable) {
        this.row = row;
        this.movable = movable;
    }

    public static Step imMovable() {
        return new Step(false);
    }

    public static Step movablePrev(int linePosition, int stepPosition, Movement movement) {
        if (movement.isMovable()) {
            return new Step(Row.of(linePosition - 1, stepPosition), true);
        }
        return new Step(false);
    }

    public static Step movableNext(int linePosition, int stepPosition, Movement movement) {
        if (movement.isMovable()) {
            return new Step(Row.of(linePosition + 1, stepPosition), true);
        }
        return new Step(false);
    }

    public int getStepPosition() {
        return row.getCurrentStep();
    }

    public boolean isMovableLine(int linePosition) {
        return movable && row.isEqualLinePosition(linePosition);
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
