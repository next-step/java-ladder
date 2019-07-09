package com.jaeyeonling.ladder.domain.line;

import com.jaeyeonling.ladder.domain.GameInfo;

@FunctionalInterface
public interface LinesFactory {

    Lines create(final GameInfo gameInfo, final HeightOfLadder heightOfLadder);
}
