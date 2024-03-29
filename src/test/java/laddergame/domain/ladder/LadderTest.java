package laddergame.domain.ladder;

import laddergame.domain.ladder.strategy.LinkStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    @Test
    @DisplayName("생성된 Ladder 인스턴스의 lines의 크기는 heightOfLadder와 동일하다.")
    void testInstanceCreation() {
        int heightOfLadder = 5;
        int numberOfPlayers = 4;
        LinkStrategy linkStrategyStub = () -> true;

        List<Line> lines = Ladder.newLadder(heightOfLadder, numberOfPlayers, linkStrategyStub)
                .lines();

        assertThat(lines.size()).isEqualTo(heightOfLadder);
    }
}
