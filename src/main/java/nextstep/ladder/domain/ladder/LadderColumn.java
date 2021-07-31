package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.strategy.StepGenerateStrategy;

import java.util.Objects;

// 하나의 기둥을 뜻함 따라서 사다리의 폭이 n 이여도 기둥은 n+1 개 생성
public class LadderColumn {

    private final Step step;

    private LadderColumn(Step step) {
        this.step = step;
    }

    public static LadderColumn initFirst(StepGenerateStrategy stepGenerateStrategy) {
        return new LadderColumn(stepGenerateStrategy.generateFirst());
    }

    public LadderColumn initNext(StepGenerateStrategy stepGenerateStrategy) {
        return new LadderColumn(stepGenerateStrategy.generateMiddle(step));
    }

    public LadderColumn initLast(StepGenerateStrategy stepGenerateStrategy) {
        return new LadderColumn(stepGenerateStrategy.generateLast(step));
    }

    public boolean hasRightStep() {
        return step.isRight();
    }

    public LadderPosition ride(LadderPosition currentPosition) {
        return step.move(currentPosition);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderColumn ladderColumn = (LadderColumn) o;
        return step == ladderColumn.step;
    }

    @Override
    public int hashCode() {
        return Objects.hash(step);
    }
}
