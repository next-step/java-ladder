package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.strategy.StepGenerateStrategy;

import java.util.Objects;

public class Column {

    private final Step step;

    private Column(Step step) {
        this.step = step;
    }

    public static Column initFirst(StepGenerateStrategy stepGenerateStrategy) {
        return new Column(Step.init(stepGenerateStrategy));
    }

    public Column initNext(StepGenerateStrategy stepGenerateStrategy) {
        return new Column(step.initNext(stepGenerateStrategy));
    }

    public Column initLast() {
        return new Column(step.initLast());
    }

    public boolean hasRightStep() {
        return step.isRight();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Column column = (Column) o;
        return step == column.step;
    }

    @Override
    public int hashCode() {
        return Objects.hash(step);
    }
}
