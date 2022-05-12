package ladder.domain.row;

import ladder.domain.step.Step;
import ladder.domain.step.Steps;
import ladder.domain.step.strategy.UnCrossableStrategy;

public class Row {
    static final int ROW_START_INDEX = 1;

    private final Steps steps;

    public Row(Steps steps) {
        validate(steps);
        this.steps = steps;
    }

    private void validate(Steps steps) {
        if (steps == null) {
            throw new IllegalArgumentException("steps는 null 일 수 없습니다.");
        }
    }

    public static Row from(int playersSize) {
        Steps steps = new Steps();

        for (int i = ROW_START_INDEX; i < playersSize; i++) {
            steps = extendSteps(steps);
        }

        return new Row(steps);
    }

    private static Steps extendSteps(Steps steps) {
        return steps.extend(generateStep(steps));
    }

    private static Step generateStep(Steps steps) {
        if (steps.lastIsCrossable()) {
            return new Step(new UnCrossableStrategy());
        }

        return new Step();
    }

    public Steps getSteps() {
        return steps;
    }
}
