package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ResultOfLadderTest {
    @Nested
    @DisplayName("winningContentOfPlayer() 테스트")
    class WinningContentOfPlayerTest {
        Map<Player, WinningContent> results = new HashMap<>() {{
            put(Player.valueOf("A"), WinningContent.valueOf("a"));
            put(Player.valueOf("B"), WinningContent.valueOf("b"));
        }};
        ResultOfLadder resultOfLadder = ResultOfLadder.valueOf(results);

        @Test
        @DisplayName("player가 존재하지 않는 경우 IllegalArgumentException이 발생한다.")
        void testFailCase() {
            assertThatThrownBy(() -> resultOfLadder.winningContentOfPlayer(Player.valueOf("C"))).isExactlyInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @CsvSource(value = {"A:a", "B:b"}, delimiter = ':')
        @DisplayName("player의 winningContent를 반환한다.")
        void testSuccessCase(String player, String winningContent) {
            assertThat(resultOfLadder.winningContentOfPlayer(Player.valueOf(player))).isEqualTo(WinningContent.valueOf(winningContent));
        }
    }
}