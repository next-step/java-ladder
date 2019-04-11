package domain.ladder;

import org.junit.Test;
import util.BridgeGenerator;
import util.BridgeRandomGenerator;

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
}
