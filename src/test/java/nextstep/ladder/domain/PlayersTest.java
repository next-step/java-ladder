package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayersTest {

    private Players players = Players.newInstance(
            Arrays.asList(
                    Player.newInstance("a", 0),
                    Player.newInstance("b", 1),
                    Player.newInstance("c", 2))
    );

    @DisplayName("사용자 리스트가 존재하지 않으면 생성할 수 없다.")
    @Test
    void canNotCreatePlayersIfPlayersIsNull() {
        assertThatThrownBy(() -> Players.newInstance(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 2명보다 작으면 생성할 수 없다.")
    @ParameterizedTest
    @MethodSource("generateInvalidPlayers")
    void canNotCreatePlayersIfLessThan2Player(List<Player> players) {
        assertThatThrownBy(() -> Players.newInstance(players))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> generateInvalidPlayers() {
        return Stream.of(
                Arguments.of(new ArrayList<Player>()),
                Arguments.of(Arrays.asList(Player.newInstance("a", 0)))
        );
    }

    @DisplayName("사용자 리스트가 유효하지 않은 사용자가 있을 경우 생성할 수 없다.")
    @Test
    void canNotCreatePlayersIfPlayersContainsNull() {
        assertThatThrownBy(() -> Players.newInstance(Arrays.asList(Player.newInstance("a", 0), null)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자 목록을 생성할 수 있다.")
    @Test
    void canCreatePlayers() {
        assertThat(this.players).isInstanceOf(Players.class);
    }

    @DisplayName("사용자 수를 얻을 수 있다.")
    @Test
    void canGetCountPlayers() {
        assertThat(this.players.getCount()).isEqualTo(3);
    }

    @DisplayName("사용자 리스트를 얻을 수 있다.")
    @Test
    void canToList() {
        assertThat(this.players.toList()).isInstanceOf(List.class);
    }

    @DisplayName("사용자 이름으로 사용자를 찾을 수 있다.")
    @ParameterizedTest
    @MethodSource("generatePlayerName")
    void canFindByName(PlayerName playerName, Player result) {
        assertThat(this.players.findByName(playerName)).isEqualTo(result);
    }

    static Stream<Arguments> generatePlayerName() {
        return Stream.of(
                Arguments.of(PlayerName.newInstance("a"), Player.newInstance("a", 0)),
                Arguments.of(PlayerName.newInstance("b"), Player.newInstance("b", 0)),
                Arguments.of(PlayerName.newInstance("c"), Player.newInstance("c", 0))
        );
    }
}
