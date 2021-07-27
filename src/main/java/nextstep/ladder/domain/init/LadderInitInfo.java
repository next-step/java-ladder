package nextstep.ladder.domain.init;

import nextstep.ladder.domain.strategy.StepGenerateStrategy;

import java.util.Objects;

import static nextstep.ladder.domain.strategy.RandomStepGenerateStrategy.HALF_PERCENT_STEP_STRATEGY;

public class LadderInitInfo {

    private final LadderSize ladderSize;
    private final StepGenerateStrategy stepGenerateStrategy;

    private LadderInitInfo(LadderSize ladderSize, StepGenerateStrategy stepGenerateStrategy) {
        validate(ladderSize, stepGenerateStrategy);

        this.ladderSize = ladderSize;
        this.stepGenerateStrategy = stepGenerateStrategy;
    }

    private void validate(LadderSize ladderSize, StepGenerateStrategy stepGenerateStrategy) {
        if (Objects.isNull(ladderSize)) {
            throw new IllegalArgumentException("LadderSize can't be null");
        }

        if (Objects.isNull(stepGenerateStrategy)) {
            throw new IllegalArgumentException("StepGenerateStrategy can't be null");
        }
    }

    public static LadderInitInfo init(LadderSize ladderSize, StepGenerateStrategy stepGenerateStrategy) {
        return new LadderInitInfo(ladderSize, stepGenerateStrategy);
    }

    public static LadderInitInfo init(LadderSize ladderSize) {
        return new LadderInitInfo(ladderSize, HALF_PERCENT_STEP_STRATEGY);
    }

    public int getLadderWidth() {
        return ladderSize.getWidth();
    }

    public boolean isEqualToWidth(int width) {
        return ladderSize.isEqualToWidth(width);
    }

    public int getLadderHeight() {
        return ladderSize.getHeight();
    }

    public StepGenerateStrategy getStepGenerateStrategy() {
        return stepGenerateStrategy;
    }

    public boolean isUnderWidth(int size) {
        return ladderSize.isUnderWidth(size);
    }
}
