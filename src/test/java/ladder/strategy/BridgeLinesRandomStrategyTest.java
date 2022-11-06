package ladder.strategy;

import ladder.domain.BridgeLines;
import ladder.domain.BridgeLinesRandomStrategy;
import ladder.domain.BridgeLinesStrategy;
import ladder.domain.LadderHeight;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class BridgeLinesRandomStrategyTest {

    @DisplayName("사다리 다리 라인들 생성 테스트")
    @Test
    void create() {
        BridgeLines bridgeLines = assertDoesNotThrow(() -> {
            BridgeLinesStrategy strategy = new BridgeLinesRandomStrategy();
            return strategy.create(4, new LadderHeight(5));
        });

        assertThat(bridgeLines).isNotNull();
    }
}
