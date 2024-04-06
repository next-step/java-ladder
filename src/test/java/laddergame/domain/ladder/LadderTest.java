package laddergame.domain.ladder;

import laddergame.domain.*;
import laddergame.domain.ladder.strategy.LinkStrategy;
import laddergame.utilForTest.PlayersUtilForTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static laddergame.domain.ladder.Link.LINKED;
import static laddergame.domain.ladder.Link.UNLINKED;
import static laddergame.utilForTest.WinningContentsUtilForTest.newWinningContents;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {
    @Test
    @DisplayName("생성된 Ladder 인스턴스의 lines의 크기는 heightOfLadder와 동일하다.")
    void testInstanceCreation() {
        HeightOfLadder heightOfLadder = new HeightOfLadder(5);
        PlayersAndWinningContents playersAndWinningContents = new PlayersAndWinningContents(PlayersUtilForTest.newPlayers("a", "b"), newWinningContents("10", "꽝"));
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
            PlayersAndWinningContents playersAndWinningContents = new PlayersAndWinningContents(PlayersUtilForTest.newPlayers("a", "b"), newWinningContents("10", "꽝"));
            Ladder ladder = Ladder.newLadder(Line.newLine(LINKED, UNLINKED));
            assertThatThrownBy(() -> ladder.resultOfLadder(playersAndWinningContents)).isExactlyInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("사다리 결과(ResultOfLadder)를 반환한다.")
        void successCase() {
            Player playerA = new Player("pobi");
            Player playerB = new Player("honux");
            Player playerC = new Player("crong");
            Player playerD = new Player("jk`");
            Players players = PlayersUtilForTest.newPlayers(playerA, playerB, playerC, playerD);

            WinningContent winningContentA = new WinningContent("꽝");
            WinningContent winningContentB = new WinningContent("5000");
            WinningContent winningContentC = new WinningContent("꽝");
            WinningContent winningContentD = new WinningContent("3000");
            WinningContents winningContents = newWinningContents(winningContentA, winningContentB, winningContentC, winningContentD);

            PlayersAndWinningContents playersAndWinningContents = new PlayersAndWinningContents(players, winningContents);

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
