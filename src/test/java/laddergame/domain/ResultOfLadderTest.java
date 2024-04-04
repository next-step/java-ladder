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
            put(Player.valueOf("A"), WinningContent.valueOf("a"));
            put(Player.valueOf("B"), WinningContent.valueOf("b"));
        }};
        ResultOfLadder resultOfLadder = ResultOfLadder.valueOf(results);

        assertThat(resultOfLadder.winningContentOfPlayer(Player.valueOf("A"))).isEqualTo(Optional.of(WinningContent.valueOf("a")));
        assertThat(resultOfLadder.winningContentOfPlayer(Player.valueOf("C")).isEmpty()).isTrue();
    }
}