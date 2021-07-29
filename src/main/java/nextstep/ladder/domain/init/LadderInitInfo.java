package nextstep.ladder.domain.init;

import nextstep.ladder.domain.strategy.NeverGenerateStrategy;
import nextstep.ladder.domain.strategy.StepGenerateStrategy;
import nextstep.ladder.exception.NullArgumentException;

import java.util.Objects;

import static nextstep.ladder.domain.ladder.LadderRow.ONE;
import static nextstep.ladder.domain.strategy.NeverGenerateStrategy.NEVER_GENERATE_STRATEGY;
import static nextstep.ladder.domain.strategy.RandomGenerateStrategy.HALF_PERCENT_STEP_STRATEGY;

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
            throw new NullArgumentException(LadderSize.class);
        }

        if (Objects.isNull(stepGenerateStrategy)) {
            throw new NullArgumentException(LadderSize.class);
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

    public int getLadderHeight() {
        return ladderSize.getHeight();
    }

    public StepGenerateStrategy getStepGenerateStrategy() {
        if (ladderSize.isEqualToWidth(ONE)) {
            return NEVER_GENERATE_STRATEGY;
        }

        return stepGenerateStrategy;
    }

    public boolean isLadderWidthEqualTo(int size) {
        return ladderSize.isEqualToWidth(size);
    }
}
