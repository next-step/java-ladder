package laddergame.domain.ladder;

import java.util.List;

@FunctionalInterface
public interface BridgeGenerator {
    List<Bridge> generate(int numberOfPlayer);
}
