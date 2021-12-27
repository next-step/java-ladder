package ladderstep4.ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class PlayersTest {
    @Test
    void 유효한_이름으로_Players생성_콤마로구분() {
        assertDoesNotThrow(() -> new Players("pobi,honux,crong,jk"));
    }

    @ParameterizedTest
    @MethodSource(value = "providePositionAndPlayer")
    void 포지션에_해당하는_플레이어_반환(int value, String name) {
        Players players = new Players("pobi,honux,crong,jk");
        assertThat(players.findPlayer(new Position(value))).isEqualTo(new Player(name));
    }

    private static Stream<Arguments> providePositionAndPlayer() {
        return Stream.of(
                Arguments.of(0, "pobi"),
                Arguments.of(1, "honux"),
                Arguments.of(2, "crong"),
                Arguments.of(3, "jk")
        );
    }
}
