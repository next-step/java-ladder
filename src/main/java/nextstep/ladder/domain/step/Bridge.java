package nextstep.ladder.domain.step;

import java.util.Objects;

public class Bridge {
    private static final int ONE = 1;

    private final int linePosition;
    private final int stepPosition;

    private Bridge(int linePosition, int stepPosition) {
        validateLinePosition(linePosition);
        validateStepPosition(stepPosition);

        this.linePosition = linePosition;
        this.stepPosition = stepPosition;
    }

    private void validateStepPosition(int stepPosition) {
        if (isNegative(stepPosition)) {
            throw new IllegalArgumentException("스텝 위치는 음수 일수 없습니다.");
        }
    }

    private void validateLinePosition(int linePosition) {
        if (isNegative(linePosition)) {
            throw new IllegalArgumentException("라인 위치는 음수 일수 없습니다.");
        }
    }

    private boolean isNegative(int position) {
        return position < 0;
    }

    public static Bridge previous(Bridge bridge) {
        return new Bridge(decreaseOne(bridge.linePosition), bridge.stepPosition);
    }

    public static Bridge current(int linePosition, int stepPosition) {
        return new Bridge(linePosition, stepPosition);
    }

    public static Bridge next(int linePosition, int stepPosition) {
        return new Bridge(increaseOne(linePosition), stepPosition);
    }

    public static Bridge next(Bridge bridge) {
        return new Bridge(increaseOne(bridge.linePosition), bridge.stepPosition);
    }

    private static int increaseOne(int position) {
        return position + ONE;
    }

    private static int decreaseOne(int position) {
        return position - ONE;
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
