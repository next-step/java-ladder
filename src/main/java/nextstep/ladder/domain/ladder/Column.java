package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.strategy.StepGenerateStrategy;

public class Column {

    private final Step step;

    private Column(StepGenerateStrategy stepGenerateStrategy) {
        this.step = Step.init(stepGenerateStrategy);
    }

    public static Column init(StepGenerateStrategy stepGenerateStrategy) {
        return new Column(stepGenerateStrategy);
    }

    public Column initNext(StepGenerateStrategy stepGenerateStrategy) {
        return null;
    }

    public boolean hasRightStep() {
        return step.isRight();
    }
}
