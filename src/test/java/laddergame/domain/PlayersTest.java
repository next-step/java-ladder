package laddergame.domain;

import laddergame.exception.InvalidPlayersException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayersTest {
    @Test
    @DisplayName("Players 인스턴스 생성시 players의 크기가 PLAYERS_MIN_NUMBER보다 작은 경우 InvalidPlyaersException이 발생한다.")
    void testInstanceCreationFail() {
        List<Player> players = List.of(Player.valueOf("a"));
        assertThatThrownBy(() -> Players.valueOf(players))
                .isExactlyInstanceOf(InvalidPlayersException.class);
    }

    @Test
    @DisplayName("findPlayerByIndex(): players 중 전달된 index 순서에 해당하는 player를 반환한다.")
    void testFindPlayerByIndex() {
        Player firstPlayer = Player.valueOf("a");
        Player secondPlayer = Player.valueOf("b");
        Players players = Players.valueOf(List.of(firstPlayer, secondPlayer));

        assertThat(players.findPlayerByIndex(0)).isEqualTo(firstPlayer);
        assertThat(players.findPlayerByIndex(1)).isEqualTo(secondPlayer);
    }
}
