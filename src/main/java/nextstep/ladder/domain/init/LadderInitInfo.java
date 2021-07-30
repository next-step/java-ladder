package nextstep.ladder.domain.init;

import nextstep.ladder.domain.strategy.StepGenerateStrategyTemp;
import nextstep.ladder.exception.NullArgumentException;

import java.util.Objects;

import static nextstep.ladder.domain.ladder.LadderRow.ONE;
import static nextstep.ladder.domain.strategy.NeverGenerateStrategyTemp.NEVER_GENERATE_STRATEGY_TEMP;
import static nextstep.ladder.domain.strategy.RandomGenerateStrategyTemp.HALF_PERCENT_STEP_STRATEGY_TEMP;

public class LadderInitInfo {

    private final LadderSize ladderSize;
    private final StepGenerateStrategyTemp stepGenerateStrategyTemp;

    private LadderInitInfo(LadderSize ladderSize, StepGenerateStrategyTemp stepGenerateStrategy) {
        validate(ladderSize, stepGenerateStrategy);

        this.ladderSize = ladderSize;
        this.stepGenerateStrategyTemp = stepGenerateStrategy;
    }

    private void validate(LadderSize ladderSize, StepGenerateStrategyTemp stepGenerateStrategy) {
        if (Objects.isNull(ladderSize)) {
            throw new NullArgumentException(LadderSize.class);
        }

        if (Objects.isNull(stepGenerateStrategy)) {
            throw new NullArgumentException(StepGenerateStrategyTemp.class);
        }
    }

    public static LadderInitInfo init(LadderSize ladderSize, StepGenerateStrategyTemp stepGenerateStrategy) {
        return new LadderInitInfo(ladderSize, stepGenerateStrategy);
    }

    public static LadderInitInfo init(LadderSize ladderSize) {
        return new LadderInitInfo(ladderSize, HALF_PERCENT_STEP_STRATEGY_TEMP);
    }

    public int getLadderWidth() {
        return ladderSize.getWidth();
    }

    public int getLadderHeight() {
        return ladderSize.getHeight();
    }

    public StepGenerateStrategyTemp getStepGenerateStrategy2() {
        if (ladderSize.isEqualToWidth(ONE)) {
            return NEVER_GENERATE_STRATEGY_TEMP;
        }

        return stepGenerateStrategyTemp;
    }

    public boolean isLadderWidthEqualTo(int size) {
        return ladderSize.isEqualToWidth(size);
    }
}
