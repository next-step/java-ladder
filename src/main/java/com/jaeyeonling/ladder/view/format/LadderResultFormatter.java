package com.jaeyeonling.ladder.view.format;

import com.jaeyeonling.ladder.domain.ladder.LadderResult;

public class LadderResultFormatter implements Formatter<LadderResult> {

    @Override
    public String format(final LadderResult ladderResult) {
        return ladderResult.getLadderResult();
    }
}
