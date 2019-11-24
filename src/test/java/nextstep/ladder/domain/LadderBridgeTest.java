package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderBridgeTest {
    @Test
    void find_ladder_first_bridge() {
        LadderBridge ladderBridge = LadderBridge.findLadderBridge(Boolean.TRUE, Boolean.TRUE);
        assertThat(ladderBridge).isEqualTo(LadderBridge.FIRST_BRIDGE);
    }

    @Test
    void find_ladder_first_empty_bridge() {
        LadderBridge ladderBridge = LadderBridge.findLadderBridge(Boolean.FALSE, Boolean.TRUE);
        assertThat(ladderBridge).isEqualTo(LadderBridge.FIRST_EMPTY);
    }

    @Test
    void find_ladder_bridge() {
        LadderBridge ladderBridge = LadderBridge.findLadderBridge(Boolean.TRUE, Boolean.FALSE);
        assertThat(ladderBridge).isEqualTo(LadderBridge.BRIDGE);
    }

    @Test
    void find_ladder_empty() {
        LadderBridge ladderBridge = LadderBridge.findLadderBridge(Boolean.FALSE, Boolean.FALSE);
        assertThat(ladderBridge).isEqualTo(LadderBridge.EMPTY);
    }
}