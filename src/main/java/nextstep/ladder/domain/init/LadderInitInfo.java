package nextstep.ladder.domain.init;

import nextstep.ladder.domain.strategy.StepGenerateStrategy;

public class LadderInitInfo {

    private final LadderSize ladderSize;
    private final StepGenerateStrategy stepGenerateStrategy;

    private LadderInitInfo(LadderSize ladderSize, StepGenerateStrategy stepGenerateStrategy) {
        this.ladderSize = ladderSize;
        this.stepGenerateStrategy = stepGenerateStrategy;
    }

    public static LadderInitInfo init(LadderSize ladderSize, StepGenerateStrategy stepGenerateStrategy) {
        return new LadderInitInfo(ladderSize, stepGenerateStrategy);
    }

}
