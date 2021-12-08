package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class PlayersTest {
    private Players players;

    @BeforeEach
    void setUp() {
        players = Players.from(new String[] {"a", "b", "c", "d", "e"});
    }

    @ParameterizedTest
    @DisplayName("Players 의 생성인자가 2이하 라면 예외가 발생한다")
    @MethodSource
    void createException(String[] names) {
        assertThatThrownBy(() -> Players.from(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> createException() {
        return Stream.of(
                Arguments.of(
                        (Object) new String[] {}
                ),
                Arguments.of(
                        (Object) new String[] {"a"}
                )
        );
    }

    @ParameterizedTest
    @DisplayName("생성된 선수들의 숫자를 리턴한다")
    @MethodSource
    void playersCount(Players players, int expected) {
        assertThat(players.playersCount()).isEqualTo(expected);
    }

    static Stream<Arguments> playersCount() {
        return Stream.of(
                Arguments.of(
                        Players.from(new String[] {"hi", "hello"}), 2
                ),
                Arguments.of(
                        Players.from(new String[] {"hi", "hello", "world"}), 3
                )
        );
    }

    @ParameterizedTest
    @DisplayName("해당 인덱스에 해당하는 Player를 리턴한다")
    @MethodSource
    void findPlayerOfIndex(int index, Player findPlayer) {
        assertThat(players.playerOfIndex(index)).isEqualTo(findPlayer);
    }

    static Stream<Arguments> findPlayerOfIndex() {
        return Stream.of(
                Arguments.of(
                        0, Player.from("a")
                ),
                Arguments.of(
                        1, Player.from("b")
                ),
                Arguments.of(
                        2, Player.from("c")
                ),
                Arguments.of(
                        3, Player.from("d")
                ),
                Arguments.of(
                        4, Player.from("e")
                )
        );
    }
}