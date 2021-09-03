package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThatCode;

import nextstep.ladder.exception.WrongPlayerException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "가나다", "aaaa", "あいうえお"})
    void createPlayer(String name) {
        assertThatCode(() -> new Player(name))
            .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("플레이어 이름에 공백혹은 null이 입력될 경우 예외를 던진다.")
    void notNullOrEmptyName(String name) {
        Assertions.assertThatThrownBy(() -> new Player(name))
            .isInstanceOf(WrongPlayerException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"aaaaaa", "가나다라마바"})
    @DisplayName("플레이어 이름은 최대 5글자를 초과할경우 예외를 던진다.")
    void notOverMaxLength(String name) {
        Assertions.assertThatThrownBy(() -> new Player(name))
            .isInstanceOf(WrongPlayerException.class);
    }
}