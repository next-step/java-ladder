package nextstep.ladder.domain;

import nextstep.ladder.exception.InputValueException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {

    private Player player = Player.newInstance("abcde");

    @DisplayName("이름이 존재하지 않으면 생성할 수 없다.")
    @ParameterizedTest
    @MethodSource("generateInvalidName")
    void canNotCreatePlayerIfNameIsBlank(String name) {
        assertThatThrownBy(() -> Player.newInstance(name))
                .isInstanceOf(InputValueException.class);
    }

    static Stream<Arguments> generateInvalidName() {
        return Stream.of(
                Arguments.of((Object) null),
                Arguments.of(""),
                Arguments.of(" ")
        );
    }

    @DisplayName("이름의 길이가 5글자 초과하면 생성할 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = { "abcdef", "abcdefg", "abcdefgh" })
    void canNotCreatePlayerIfNameLengthExceeds5(String name) {
        assertThatThrownBy(() -> Player.newInstance(name))
                .isInstanceOf(InputValueException.class);
    }

    @DisplayName("사용자를 생성할 수 있다.")
    @Test
    void canCreatePlayer() {
        assertThat(this.player).isInstanceOf(Player.class);
    }

    @DisplayName("사용자의 이름을 얻을 수 있다.")
    @Test
    void canToStringPlayerName() {
        assertThat(this.player.toString()).isEqualTo("abcde");
    }

}
