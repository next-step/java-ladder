package nextstep.ladder.domain.step;

import nextstep.ladder.domain.step.strategy.Movement;

import java.util.Objects;

public class Step {
    private final Bridge bridge;
    private final boolean movable;

    private Step(Bridge bridge, boolean movable) {
        this.bridge = bridge;
        this.movable = movable;
    }

    public static Step of(Bridge bridge, Movement movement) {
        return new Step(bridge, movement.isMovable());
    }

    public int getPosition() {
        return bridge.getStepPosition();
    }

    public boolean isMovableLine(int linePosition) {
        return bridge.isEqaulLinePosition(linePosition) && movable;
    }

    public boolean isMovableNext(int linePosition) {
        return !(bridge.isEqaulLinePosition(linePosition + 1) && movable);
    }

    public boolean isMovablePrev(int linePosition) {
        return bridge.isEqaulLinePosition(linePosition + 1) && movable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Step step = (Step) o;
        return movable == step.movable &&
                Objects.equals(bridge, step.bridge);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movable, bridge);
    }
}
