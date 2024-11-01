package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderTest {

    @Test
    @DisplayName("사다리 생성 테스트")
    public void createLadder() {
        Ladder ladder = new Ladder();

        ConnectionStrategy alwaysTrueStrategy = new FakeConnectionStrategy(true);

        List<Bridge> steps = ladder.createSteps(5, 4, alwaysTrueStrategy);

        assertThat(steps.size()).isEqualTo(5);
        steps.forEach(bridge -> {
            assertThat(bridge.getConnections().size()).isEqualTo(3);
        });
    }

}
