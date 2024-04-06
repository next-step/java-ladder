package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class ResultOfLadderTest {
    @Test
    @DisplayName("winningContentOfPlayer(): player의 winningContent를 반환한다.")
    void testSuccessCase() {
        Map<Player, WinningContent> results = new HashMap<>() {{
            put(new Player("A"), new WinningContent("a"));
            put(new Player("B"), new WinningContent("b"));
        }};
        ResultOfLadder resultOfLadder = new ResultOfLadder(results);

        assertThat(resultOfLadder.winningContentOfPlayer(new Player("A"))).isEqualTo(Optional.of(new WinningContent("a")));
        assertThat(resultOfLadder.winningContentOfPlayer(new Player("C")).isEmpty()).isTrue();
    }
}