package nextstep.ladder.domain.step.strategy;

import nextstep.ladder.domain.step.Step;
import nextstep.ladder.domain.step.Steps;

@FunctionalInterface
public interface MovableSide {
    boolean isMovable(Steps steps, Step step);
}
