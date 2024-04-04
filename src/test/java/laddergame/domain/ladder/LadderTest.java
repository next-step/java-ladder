package laddergame.domain.ladder;

import laddergame.domain.*;
import laddergame.domain.ladder.strategy.LinkStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static laddergame.domain.ladder.Link.LINKED;
import static laddergame.domain.ladder.Link.UNLINKED;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Nested
    @DisplayName("resultOfLadder() 테스트")
    class ResultOfLadderTest {
        @Test
        @DisplayName("PlayersAndWinningContents.numberOfLinks()가 Line.numberOfLinks()와 다른 경우 IllegalArgumentException이 발생한다.")
        void testFailCase() {
            PlayersAndWinningContents playersAndWinningContents = PlayersAndWinningContents.newPlayersAndWinnings(Players.newPlayers("a", "b"), WinningContents.newWinningContents("10", "꽝"));
            Ladder ladder = Ladder.newLadder(Line.newLine(LINKED, UNLINKED));
            assertThatThrownBy(() -> ladder.resultOfLadder(playersAndWinningContents)).isExactlyInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("사다리 결과(ResultOfLadder)를 반환한다.")
        void successCase() {
            Player playerA = Player.valueOf("pobi");
            Player playerB = Player.valueOf("honux");
            Player playerC = Player.valueOf("crong");
            Player playerD = Player.valueOf("jk");
            Players players = Players.newPlayers(playerA, playerB, playerC, playerD);

            WinningContent winningContentA = WinningContent.valueOf("꽝");
            WinningContent winningContentB = WinningContent.valueOf("5000");
            WinningContent winningContentC = WinningContent.valueOf("꽝");
            WinningContent winningContentD = WinningContent.valueOf("3000");
            WinningContents winningContents = WinningContents.newWinningContents(winningContentA, winningContentB, winningContentC, winningContentD);

            PlayersAndWinningContents playersAndWinningContents = PlayersAndWinningContents.newPlayersAndWinnings(players, winningContents);

            Ladder ladder = Ladder.newLadder(Line.newLine(LINKED, UNLINKED, LINKED),
                    Line.newLine(UNLINKED, LINKED, UNLINKED),
                    Line.newLine(LINKED, UNLINKED, UNLINKED),
                    Line.newLine(UNLINKED, LINKED, UNLINKED),
                    Line.newLine(LINKED, UNLINKED, LINKED));

            ResultOfLadder resultOfLadder = ladder.resultOfLadder(playersAndWinningContents);

            assertThat(resultOfLadder.winningContentOfPlayer(playerA)).isEqualTo(Optional.of(winningContentA));
            assertThat(resultOfLadder.winningContentOfPlayer(playerB)).isEqualTo(Optional.of(winningContentD));
            assertThat(resultOfLadder.winningContentOfPlayer(playerC)).isEqualTo(Optional.of(winningContentC));
            assertThat(resultOfLadder.winningContentOfPlayer(playerD)).isEqualTo(Optional.of(winningContentB));
        }
    }
}
