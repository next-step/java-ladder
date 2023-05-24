package nextstep.ladder.domain.engine;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.domain.strategy.BridgeStrategy;

public interface LadderCreator {
    Ladder create(Participants participants, Height height, BridgeStrategy strategy);
}
