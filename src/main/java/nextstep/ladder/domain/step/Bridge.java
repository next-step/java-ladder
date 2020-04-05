package nextstep.ladder.domain.step;

import nextstep.ladder.domain.Position;

import java.util.Objects;

public class Bridge {
    private static final int ONE = 1;

    private final Position linePosition;
    private final Position stepPosition;

    private Bridge(int linePosition, int stepPosition) {
        this.linePosition = new Position(linePosition);
        this.stepPosition = new Position(stepPosition);
    }

    public static Bridge previous(Bridge bridge) {
        return new Bridge(decreaseOne(bridge.getLinePosition()), bridge.getStepPosition());
    }

    public static Bridge current(int linePosition, int stepPosition) {
        return new Bridge(linePosition, stepPosition);
    }

    public static Bridge next(int linePosition, int stepPosition) {
        return new Bridge(increaseOne(linePosition), stepPosition);
    }

    public static Bridge next(Bridge bridge) {
        return new Bridge(increaseOne(bridge.getLinePosition()), bridge.getStepPosition());
    }

    private static int increaseOne(int position) {
        return position + ONE;
    }

    private static int decreaseOne(int position) {
        return position - ONE;
    }

    public int getStepPosition() {
        return stepPosition.getPosition();
    }

    public int getLinePosition() {
        return linePosition.getPosition();
    }

    public boolean isEqaulLinePosition(int linePosition) {
        return this.linePosition.isEqualPosition(linePosition);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bridge bridge = (Bridge) o;
        return linePosition == bridge.linePosition &&
                stepPosition == bridge.stepPosition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(linePosition, stepPosition);
    }
}
