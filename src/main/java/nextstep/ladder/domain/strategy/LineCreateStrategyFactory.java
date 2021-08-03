package nextstep.ladder.domain.strategy;

import nextstep.ladder.domain.info.LadderInfo;

public class LineCreateStrategyFactory {
    private static final LineCreateStrategy LINE_NOT_CREATE_STRATEGY = () -> false;

    public static LineCreateStrategy getStrategy(LadderInfo ladderInfo) {
        if (ladderInfo.isMinWidthSize()) {
            return LINE_NOT_CREATE_STRATEGY;
        }

        return ladderInfo.getLineCreateStrategy();
    }

}
