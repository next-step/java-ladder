package domain.ladder;

import domain.bridge.TestBridgeGenerator;
import org.junit.Test;
import domain.bridge.BridgeGenerator;
import domain.bridge.BridgeRandomGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    public void generateLadder() {
        int ladderHeight = 5;
        int userCount = 3;
        BridgeGenerator bridgeGenerator = new BridgeRandomGenerator();

        Ladder ladder = new Ladder(ladderHeight, userCount, bridgeGenerator);
        int result = ladder.size();
        assertThat(result).isEqualTo(ladderHeight);
    }

    @Test
    public void 최종위치_구하기() {
        int ladderHeight = 3;
        int userCount = 3;
        BridgeGenerator bridgeGenerator = new TestBridgeGenerator();

        Ladder ladder = new Ladder(ladderHeight, userCount, bridgeGenerator);
        assertThat(ladder.result(0)).isEqualTo(1);
        assertThat(ladder.result(1)).isEqualTo(0);
        assertThat(ladder.result(2)).isEqualTo(2);
    }
}
