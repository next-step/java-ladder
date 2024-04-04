package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

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

    @Nested
    @DisplayName("findPlayerByName() 테스트")
    class FindPlayerByNameTest {
        Players players = Players.newPlayers("a", "b", "c", "d");

        @Test
        @DisplayName("name을 가지는 참여자가 존재하는 경우 해당 참여자를 포함하는 List<Player>를 반환하다.")
        void testReturnSingleElementList() {
            String name = "a";

            List<Player> foundPlayers = players.findPlayersByName(name);

            assertThat(foundPlayers.size()).isEqualTo(1);
            assertThat(foundPlayers.get(0)).isEqualTo(Player.valueOf(name));
        }

        @Test
        @DisplayName("name을 가지는 참여자가 존재하지 않는 경우 비어있는 List<Player>를 반환하다.")
        void testReturnEmptyList() {
            String name = "abcd";

            List<Player> foundPlayers = players.findPlayersByName(name);

            assertThat(foundPlayers.size()).isEqualTo(0);
        }

        @Test
        @DisplayName("name이 ALL인 경우 모든 참여자들을 포함한 List<Player>를 반환한다.")
        void testReturnAllPlayers() {
            String name = "ALL";

            List<Player> foundPlayers = players.findPlayersByName(name);

            assertThat(foundPlayers.size()).isEqualTo(players.numberOfPlayers());
            IntStream.range(0, foundPlayers.size())
                    .forEach(i -> assertThat(foundPlayers.get(i)).isEqualTo(players.players().get(i)));
        }
    }


    @Test
    @DisplayName("numberOfPlayers(): Players.players의 크기를 반환한다.")
    void testNumberOfPlayers() {
        Players players = Players.newPlayers("a", "b", "c");
        assertThat(players.numberOfPlayers()).isEqualTo(3);
    }
}
