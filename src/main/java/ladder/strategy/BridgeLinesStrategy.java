package ladder.strategy;

import ladder.domain.BridgeLines;
import ladder.domain.LadderHeight;

public interface BridgeLinesStrategy {

    BridgeLines create(final int amount, final LadderHeight height);
}
