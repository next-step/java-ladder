package laddergame.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayersTest {
    @Nested
    @DisplayName("Players 인스턴스 생성 테스트")
    class InstanceCreationTest {
        @Test
        @DisplayName("인스턴스 생성시 players의 크기가 MIN_NUMBER_OF_PLAYERS_AND_WINNING_CONTENTS보다 작은 경우 IllegalArgumentException이 발생한다.")
        void testWrongSizeOfPlayers() {
            List<Player> players = List.of(Player.valueOf("a"));
            assertThatThrownBy(() -> Players.valueOf(players))
                    .isExactlyInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("인스턴스 생성시 players에 중복된 데이터가 있는 경우 IllegalArgumentException이 발생한다.")
        void testDuplicatePlayers() {
            List<Player> players = List.of(Player.valueOf("a"), Player.valueOf("a"));
            assertThatThrownBy(() -> Players.valueOf(players))
                    .isExactlyInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    @DisplayName("findPlayerByIndex(): Players.players 중 전달된 index 순서에 해당하는 player를 반환한다.")
    void testFindPlayerByIndex() {
        Player firstPlayer = Player.valueOf("a");
        Player secondPlayer = Player.valueOf("b");
        Players players = Players.newPlayers(firstPlayer, secondPlayer);

        assertThat(players.findPlayerByIndex(0)).isEqualTo(firstPlayer);
        assertThat(players.findPlayerByIndex(1)).isEqualTo(secondPlayer);
    }

    @Test
    @DisplayName("numberOfPlayers(): Players.players의 크기를 반환한다.")
    void testNumberOfPlayers() {
        Players players = Players.newPlayers("a", "b", "c");
        assertThat(players.numberOfPlayers()).isEqualTo(3);
    }
}
