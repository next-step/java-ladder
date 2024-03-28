package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class PlayersTest {

    @ParameterizedTest
    @MethodSource("playerListAndToString")
    @DisplayName("from 호출 시 매개변수인 Player의 목록이 Players의 players 필드로 초기화")
    void create(List<Player> playerList) {
        Players players = Players.from(playerList);
        assertThat(players.size()).isEqualTo(playerList.size());
    }

    @ParameterizedTest
    @MethodSource("playerListAndToString")
    @DisplayName("Player의 목록을 문자열로 반환")
    void toString(List<Player> playerList, String expected) {
        Players players = Players.from(playerList);
        assertThat(players.toString()).isEqualTo(expected);
    }

    static Stream<Arguments> playerListAndToString() {
        return Stream.of(
                Arguments.arguments(createPlayerList("abcde", "dbccd"), "abcde  dbccd"),
                Arguments.arguments(createPlayerList("ab", "cd", "ef"), "ab  cd  ef"),
                Arguments.arguments(createPlayerList("ab", "cd", "ef", "gh"), "ab  cd  ef  gh"),
                Arguments.arguments(createPlayerList("jk", "kl", "zx", "cv", "bn"), "jk  kl  zx  cv  bn"
                ));
    }

    private static List<Player> createPlayerList(String... name) {
        return Arrays.stream(name)
                .map(Player::from)
                .collect(Collectors.toList());
    }
}
