package ladder.domain.ladder;

import ladder.strategy.StepStrategy;

public class PointCreator {
    private final StepStrategy stepStrategy;
    private final int count;
    private boolean beforeStep = false;

    public PointCreator(int count, StepStrategy stepStrategy) {
        this.stepStrategy = stepStrategy;
        this.count = count;
    }

    public Point nextPoint(int index) {
        boolean beforeStep = this.beforeStep;

        if (index == count) {
            return Point.of(beforeStep, false);
        }

        this.beforeStep = stepStrategy.nextStep();
        return Point.of(beforeStep, this.beforeStep);
    }
}
