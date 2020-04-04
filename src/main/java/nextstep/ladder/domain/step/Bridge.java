package nextstep.ladder.domain.step;

import java.util.Objects;

public class Bridge {
    private final int linePosition;
    private final int stepPosition;

    private Bridge(int linePosition, int stepPosition) {
        this.linePosition = linePosition;
        this.stepPosition = stepPosition;
    }

    public static Bridge previous(int linePosition, int stepPosition) {
        return new Bridge(linePosition - 1, stepPosition);
    }

    public static Bridge previous(Bridge bridge) {
        return new Bridge(bridge.linePosition - 1, bridge.stepPosition);
    }

    public static Bridge current(int linePosition, int stepPosition) {
        return new Bridge(linePosition, stepPosition);
    }

    public static Bridge next(int linePosition, int stepPosition) {
        return new Bridge(linePosition + 1, stepPosition);
    }

    public static Bridge next(Bridge bridge) {
        return new Bridge(bridge.linePosition + 1, bridge.stepPosition);
    }

    public int getStepPosition() {
        return stepPosition;
    }

    public boolean isEqaulLinePosition(int linePosition) {
        return this.linePosition == linePosition;
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
