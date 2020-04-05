package nextstep.ladder.domain.step.strategy;

import nextstep.ladder.domain.step.Step;
import nextstep.ladder.domain.step.Steps;

public class MovableNext implements MovableSide {
    @Override
    public boolean isMovable(Steps steps, Step step) {
        return !step.isMovableLine(steps.getLinePosition() + 1);
    }
}
