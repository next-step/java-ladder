package nextstep.ladder.domain.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class GameResultTest {

    @DisplayName("결과 String으로 GameResultTest 객체를 만들 수 있다")
    @Test
    void should_make_game_result() {
        //arrange, act, assert
        assertThat(GameResult.of("aaa")).isInstanceOf(GameResult.class);
    }

    @DisplayName("게임결과는 null 이거나 비어있으면 IllegalArgumentException이 발생한다")
    @NullAndEmptySource
    @ParameterizedTest
    void should_throw_exception_when_null_or_empty(String value) {
        assertThatIllegalArgumentException().isThrownBy(() -> GameResult.of(value));
    }

    @DisplayName("게임결과는 5글자를 초과하는 경우 IllegalArgumentException이 발생한다")
    @ValueSource(strings = {"aaaaab", "aaaaabc"})
    @ParameterizedTest
    void should_throw_exception(String value) {
        assertThatIllegalArgumentException().isThrownBy(() -> GameResult.of(value));
    }
}