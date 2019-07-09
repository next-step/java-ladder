package com.jaeyeonling.ladder.view.format;

import com.jaeyeonling.ladder.domain.ladder.LadderReword;

public class LadderRewordFormatter implements Formatter<LadderReword> {

    @Override
    public String format(final LadderReword ladderReword) {
        return ladderReword.getLadderReword();
    }
}
