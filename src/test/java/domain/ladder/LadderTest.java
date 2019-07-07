package domain.ladder;

import domain.bridge.TestBridgeGenerator;
import org.junit.Test;
import domain.bridge.BridgeGenerator;
import domain.bridge.BridgeRandomGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @Test
    public void generateLadder() {
        //given
        int ladderHeight = Complexity.determineHeight("하");
        int heightLimitValue = Complexity.determineBridgeComplexity("하");
        int userCount = 3;
        BridgeGenerator bridgeGenerator = new BridgeRandomGenerator(heightLimitValue);

        //when
        Ladder ladder = new Ladder(ladderHeight, userCount, bridgeGenerator);
        int result = ladder.size();

        //then
        assertThat(result).isEqualTo(ladderHeight);
    }

    @Test
    public void 최종위치_구하기() {
        //given
        int ladderHeight = 3;
        int userCount = 3;
        BridgeGenerator bridgeGenerator = new TestBridgeGenerator();

        //when
        Ladder ladder = new Ladder(ladderHeight, userCount, bridgeGenerator);

        //then
        assertThat(ladder.result(0)).isEqualTo(1);
        assertThat(ladder.result(1)).isEqualTo(0);
        assertThat(ladder.result(2)).isEqualTo(2);
    }
}