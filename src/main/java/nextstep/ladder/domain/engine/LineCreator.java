package nextstep.ladder.domain.engine;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.strategy.BridgeStrategy;

public interface LineCreator {
    Line create(int width, BridgeStrategy strategy);
}
