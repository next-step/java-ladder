package ladder.generator;

import ladder.domain.Bridge;

import java.util.List;

public interface BridgeGenerator {
    List<Bridge> generate(int playerCount);
}
