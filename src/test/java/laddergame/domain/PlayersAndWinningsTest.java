package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayersAndWinningsTest {
    @Test
    @DisplayName("PlayersAndWinnings 인스턴스 생성시 players.players와 winnings.winngs의 크기가 다르면 IllegalArgumentException이 발생한다.")
    void testInstanceCreation() {
        assertThatThrownBy(() -> PlayersAndWinnings.newPlayersAndWinnings(Players.newPlayers("a", "b", "c"), Winnings.newWinnings("100", "꽝"))).isExactlyInstanceOf(IllegalArgumentException.class);
    }
}