package nextstep.ladder.domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayersTest {

    // 이름에 따른 user 찾기
    // 없는 이름이면 exception 발생
    private Players createPlayers(List<String> playerNames) {
        return new Players(playerNames);
    }

    @ParameterizedTest
    @MethodSource("providePlayerNamesAndFindPlayer")
    @DisplayName("findPlayer 테스트")
    void findPlayerTest(List<String> playerNames, Player findPlayer) {
        Players players = this.createPlayers(playerNames);
        Player player = players.findPlayer(findPlayer);
        assertThat(player).isEqualTo(findPlayer);
    }

    private static Stream<Arguments> providePlayerNamesAndFindPlayer() {
        return Stream.of(
                Arguments.of(Arrays.asList("il", "il2", "il3"), new Player("il", 1)),
                Arguments.of(Arrays.asList("il", "il2", "il3"), new Player("il2", 1)),
                Arguments.of(Arrays.asList("il", "il2", "il3"), new Player("il3", 1))
        );
    }

    @ParameterizedTest
    @MethodSource("providePlayerNames")
    @DisplayName("존재하지 않는 player exception")
    void findPlayerExceptionTest(List<String> playerNames) {
        Players players = this.createPlayers(playerNames);
        Player notfoundPlayer = new Player("empty", 0);
        assertThatThrownBy(() -> players.findPlayer(notfoundPlayer))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> providePlayerNames() {
        return Stream.of(
                Arguments.of(Arrays.asList("il", "il2", "il3")),
                Arguments.of(Arrays.asList("il", "il2", "il3")),
                Arguments.of(Arrays.asList("il", "il2", "il3"))
        );
    }
}