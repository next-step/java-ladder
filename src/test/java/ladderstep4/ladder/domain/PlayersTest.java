package ladderstep4.ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class PlayersTest {
    @Test
    void 유효한_이름으로_Players생성_콤마로구분() {
        assertDoesNotThrow(() -> new Players("pobi,honux,crong,jk"));
    }

    @ParameterizedTest
    @MethodSource(value = "providePositionAndPlayer")
    void 이름에_해당하는_플레이어의_포지션_반환(String name, int value) {
        Players players = new Players("pobi,honux,crong,jk");
        assertThat(players.findPositionOf(new Player(name))).isEqualTo(new Position(value));
    }

    private static Stream<Arguments> providePositionAndPlayer() {
        return Stream.of(
                Arguments.of("pobi", 0),
                Arguments.of("honux", 1),
                Arguments.of("crong", 2),
                Arguments.of("jk", 3)
        );
    }

    @Test
    void 이름에_해당하는_플레이어를_찾지못함_예외발생() {
        Players players = new Players("pobi,honux,crong,jk");
        assertThatThrownBy(() -> players.findPositionOf(new Player("catsb")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Players.CANNOT_FIND_PLAYER_MESSAGE);
    }
}
