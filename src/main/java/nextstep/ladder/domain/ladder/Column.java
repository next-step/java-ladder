package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.strategy.StepGenerateStrategy;

public class Column {

    private final Step step;

    private Column(Step step) {
        this.step = step;
    }

    public static Column init(StepGenerateStrategy stepGenerateStrategy) {
        return new Column(Step.init(stepGenerateStrategy));
    }

    public Column initNext(StepGenerateStrategy stepGenerateStrategy) {
        return new Column(step.initNext(stepGenerateStrategy));
    }

    public boolean hasRightStep() {
        return step.isRight();
    }

    public Column initLast() {
        return null;
    }
}
