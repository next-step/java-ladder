package nextstep.ladder.domain.step;

import nextstep.ladder.domain.Bridge;

public class Step {
    private final boolean movable;
    private final Bridge bridge;

    private Step(Bridge bridge, boolean movable) {
        this.bridge = bridge;
        this.movable = movable;
    }

    public static Step of(Bridge bridge, MovableStrategy movableStrategy) {
        return new Step(bridge, movableStrategy.isMovable());
    }

    public int getPosition() {
        return bridge.getStepPosition();
    }

    public boolean isMovable() {
        return movable;
    }

    public Bridge getBridge() {
        return bridge;
    }

    public boolean isEqualLinePosition(int linePosition) {
        return bridge.getLinePosition() == linePosition;
    }
}
