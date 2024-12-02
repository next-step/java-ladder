package nextstep.ladder.domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayersTest {

    @Test
    void create() {
        Players players = new Players(List.of(PlayerTest.PLAYER1, PlayerTest.PLAYER2));

        assertThat(players).isNotNull();
        assertThat(players.playerCount()).isEqualTo(2);
    }

    @Test
    @DisplayName("존재하는 플레이어인 경우 해당 플레이어의 인덱스를 반환한다")
    void findIndexByName_성공() {
        Players players = new Players(List.of(PlayerTest.PLAYER1, PlayerTest.PLAYER2));

        assertThat(players.findIndexByName("mina")).isEqualTo(0);
        assertThat(players.findIndexByName("tori")).isEqualTo(1);
    }

    @Test
    @DisplayName("존재하지 않는 플레이어인 경우 NoSuchElementException이 발생한다")
    void findIndexByName_실패() {
        Players players = new Players(List.of(PlayerTest.PLAYER1, PlayerTest.PLAYER2));

        assertThatThrownBy(() -> {
            players.findIndexByName("bob");
        }).isInstanceOf(NoSuchElementException.class);
    }
}
