package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import nextstep.ladder.exception.WrongPlayersException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

class PlayersTest {

    @ParameterizedTest
    @MethodSource("providePlayerNames")
    @DisplayName("2명이상의 플레이어 이름목록으로부터  플레이어 리스트를 생성할수 있다.")
    void createPlayers(String[] playerNames, int playerCount) {
        Players players = Players.from(playerNames);
        assertThat(players.count()).isEqualTo(playerCount);
    }

    @Test
    @NullSource
    @DisplayName("플레이어 이름목록이 null일경우에는 플레이어 리스트 생성시 예외를 던진다.")
    void createPlayers(String[] playerNames) {
        assertThatThrownBy(() -> Players.from(playerNames))
            .isInstanceOf(NullPointerException.class);
    }

    @Test
    @NullSource
    @DisplayName("플레이어수가 최소 2명이상이 아닐때, 예외를 던진다.")
    void createMinimumPlayers() {
        String[] playerNames = {"one"};
        assertThatThrownBy(() -> Players.from(playerNames))
            .isInstanceOf(WrongPlayersException.class);
    }


    private static Stream<Arguments> providePlayerNames() {
        return Stream.of(
            Arguments.of(new String[]{"a", "가나"}, 2),
            Arguments.of(new String[]{"a", "가나", "123"}, 3),
            Arguments.of(new String[]{"a", "가나", "123", "あいうえ"}, 4),
            Arguments.of(new String[]{"a", "가나", "123", "あいうえ", "一二三四五"}, 5)
        );
    }

}