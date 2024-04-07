package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static laddergame.domain.ResultOfLadder.NOT_EXIST_PLAYER;
import static org.assertj.core.api.Assertions.assertThat;

class ResultOfLadderTest {
    @Nested
    @DisplayName("winningContentOfPlayer() 테스트")
    class WinningContentOfPlayerTest {
        Map<Player, WinningContent> results = new HashMap<>() {{
            put(new Player("A"), new WinningContent("a"));
            put(new Player("B"), new WinningContent("b"));
        }};
        ResultOfLadder resultOfLadder = new ResultOfLadder(results);

        @Test
        @DisplayName("Player의 WinningContent.winningContent를 반환한다.")
        void testFailCase() {
            Map<Player, WinningContent> results = new HashMap<>() {{
                put(new Player("A"), new WinningContent("a"));
                put(new Player("B"), new WinningContent("b"));
            }};
            ResultOfLadder resultOfLadder = new ResultOfLadder(results);

            assertThat(resultOfLadder.winningContentOfPlayer(new Player("A"))).isEqualTo("a");
            assertThat(resultOfLadder.winningContentOfPlayer(new Player("B"))).isEqualTo("b");
        }

        @Test
        @DisplayName("존재하지 않는 Player라면 NOT_EXIST_PLAYER를 반환한다.")
        void testSuccessCase() {
            assertThat(resultOfLadder.winningContentOfPlayer(new Player("C"))).isEqualTo(NOT_EXIST_PLAYER);
        }
    }
}
