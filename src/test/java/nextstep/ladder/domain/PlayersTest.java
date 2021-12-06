package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayersTest {

    @ParameterizedTest
    @DisplayName("Players 의 생성인자가 1이하라면 예외가 발생한다")
    @EmptySource
    void createException(String[] names) {
        assertThatThrownBy(() -> Players.from(names))
                .isInstanceOf(IllegalArgumentException.class);
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
}