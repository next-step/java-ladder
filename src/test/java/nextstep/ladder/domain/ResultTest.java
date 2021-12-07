package nextstep.ladder.domain;

import nextstep.ladder.exception.ResultException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ResultTest {
    @ParameterizedTest
    @DisplayName("Result는 1 ~ 5의 길이의 이름으로 생성한다")
    @ValueSource(strings = {"a", "ab", "abc", "abcd", "abcde"})
    void create(String result) {
        assertThat(Result.from(result)).isInstanceOf(Result.class);
    }

    @ParameterizedTest
    @DisplayName("1 이하, 5 이상의 이름으로 생성하면 예외가 발생한다")
    @ValueSource(strings = {"", "abcdef"})
    void exception(String result) {
        assertThatThrownBy(() -> Result.from(result)).isInstanceOf(ResultException.class);
    }
}