package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    @ParameterizedTest
    @ValueSource(strings = {"", "jadelee"})
    void 생성_이름_길이(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Player(input);
                });
    }

    @ParameterizedTest
    @CsvSource(value = {"a:5", "ab:5", "abc:5", "abcd:5", "abcde:5"}, delimiter = ':')
    void 이름_출력_길이(String input, int result) {
        assertThat(new Player(input)
                .name()
                .length())
                .isEqualTo(result);
    }
}