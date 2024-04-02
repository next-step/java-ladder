package laddergame.domain.ladder;

import laddergame.domain.HeightOfLadder;
import laddergame.domain.Players;
import laddergame.domain.PlayersAndWinningContents;
import laddergame.domain.WinningContents;
import laddergame.domain.ladder.strategy.LinkStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    @Test
    @DisplayName("생성된 Ladder 인스턴스의 lines의 크기는 heightOfLadder와 동일하다.")
    void testInstanceCreation() {
        HeightOfLadder heightOfLadder = HeightOfLadder.valueOf(5);
        PlayersAndWinningContents playersAndWinningContents = PlayersAndWinningContents.newPlayersAndWinnings(Players.newPlayers("a", "b"), WinningContents.newWinningContents("10", "꽝"));
        LinkStrategy linkStrategyStub = () -> true;

        List<Line> lines = Ladder.newLadder(heightOfLadder, playersAndWinningContents, linkStrategyStub)
                .lines();

        assertThat(lines.size()).isEqualTo(heightOfLadder.height());
    }
}
