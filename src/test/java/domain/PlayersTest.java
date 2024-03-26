package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PlayersTest {

    @ParameterizedTest
    @MethodSource("createPlayerList")
    @DisplayName("List<Player>만을 가지는 일급컬렉션")
    void create(List<Player> playerList) {
        Players players = Players.from(playerList);
        Assertions.assertThat(players.size()).isEqualTo(playerList.size());
    }

    static Stream<Arguments> createPlayerList() {
        return Stream.of(
                Arguments.arguments(createPlayerList("abcde", "dbccd")),
                Arguments.arguments(createPlayerList("ab", "cd", "ef")),
                Arguments.arguments(createPlayerList("ab", "cd", "ef", "gh")),
                Arguments.arguments(createPlayerList("jk", "kl", "zx", "cv", "bn")
                ));
    }

    private static List<Player> createPlayerList(String... name) {
        return Arrays.stream(name)
                .map(Player::from)
                .collect(Collectors.toList());
    }
}
