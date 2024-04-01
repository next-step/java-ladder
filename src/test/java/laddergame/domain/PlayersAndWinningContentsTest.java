package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayersAndWinningContentsTest {
    @Test
    @DisplayName("PlayersAndWinningContents 인스턴스 생성시 players.players와 WinningContents.winningContents의 크기가 다르면 IllegalArgumentException이 발생한다.")
    void testInstanceCreation() {
        assertThatThrownBy(() -> PlayersAndWinningContents.newPlayersAndWinnings(Players.newPlayers("a", "b", "c"), WinningContents.newWinningContents("100", "꽝"))).isExactlyInstanceOf(IllegalArgumentException.class);
    }
}