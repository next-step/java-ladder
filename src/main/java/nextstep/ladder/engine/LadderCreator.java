package nextstep.ladder.engine;

import nextstep.ladder.domain.Ladder;

@FunctionalInterface
public interface LadderCreator {
    Ladder create();
}

