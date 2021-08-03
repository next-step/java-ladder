package nextstep.ladder.domain.strategy;

import nextstep.ladder.domain.info.LadderInfo;

import java.util.Random;

public class LineCreateStrategyFactory {
    private static final LineCreateStrategy LINE_NOT_CREATE_STRATEGY = () -> false;

    public static LineCreateStrategy getRandomLineCreateStrategy() {
        return RandomLineCreateStrategy.of(new Random());
    }

    public static LineCreateStrategy getStrategy(LadderInfo ladderInfo) {
        if (ladderInfo.isMinWidthSize()) {
            return LINE_NOT_CREATE_STRATEGY;
        }

        return ladderInfo.getLineCreateStrategy();
    }

}
