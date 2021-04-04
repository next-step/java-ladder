package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    @ParameterizedTest
    @DisplayName(value = "참가자 생성 인자 유효성 검증")
    @ValueSource(strings = {"", "jadelee"})
    void playerArgumentException(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Player(input);
                });
    }

    @ParameterizedTest
    @DisplayName(value = "참가자 이름 출력 길이")
    @CsvSource(value = {"a:5", "ab:5", "abc:5", "abcd:5", "abcde:5"}, delimiter = ':')
    void playerNameLength(String input, int result) {
        assertThat(new Player(input)
                .name()
                .length())
                .isEqualTo(result);
    }
}