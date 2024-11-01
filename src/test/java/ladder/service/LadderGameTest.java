package ladder.service;

import ladder.domain.Bridge;
import ladder.domain.ConnectionStrategy;
import ladder.domain.FakeConnectionStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderGameTest {

    @Test
    @DisplayName("사다리 생성 테스트")
    public void createLadder() {
        LadderGame ladderGame = new LadderGame();

        ConnectionStrategy alwaysTrueStrategy = new FakeConnectionStrategy(true);

        List<Bridge> ladder = ladderGame.createLadder(5, 4, alwaysTrueStrategy);

        assertThat(ladder.size()).isEqualTo(5);
        ladder.forEach(bridge -> {
            assertThat(bridge.getConnections().size()).isEqualTo(3);
        });
    }

}
