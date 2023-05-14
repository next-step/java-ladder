package nextstep.ladder.domain;

import static nextstep.ladder.domain.Direction.*;

public class Step {

    private final boolean previousPosition;
    private final boolean currentPosition;

    private Step(boolean previousPosition, boolean currentPosition) {
        hasOnlyTruePositions(previousPosition, currentPosition);

        this.previousPosition = previousPosition;
        this.currentPosition = currentPosition;
    }

    private void hasOnlyTruePositions(boolean previousPosition, boolean currentPosition) {
        if (previousPosition && currentPosition) {
            throw new IllegalArgumentException("선이 연속으로 생길 수 없습니다.");
        }
    }

    public static Step firstStep(boolean currentPosition) {
        return new Step(false, currentPosition);
    }

    public Step nextStep(boolean currentPosition) {
        return new Step(this.currentPosition, currentPosition);
    }

    public Step lastStep() {
        return new Step(this.currentPosition, false);
    }

    public Direction move() {
        if (currentPosition) {
            return RIGHT;
        }

        if (previousPosition) {
            return LEFT;
        }
        return PASS;
    }

    public boolean hasStep() {
        return currentPosition;
    }

    public boolean hasPreviousStep() {
        return previousPosition;
    }
}
