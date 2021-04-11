package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class PlayerTest {
    @ParameterizedTest
    @DisplayName(value = "참가자 생성 인자 유효성 검증")
    @ValueSource(strings = {"", "jadelee"})
    void playerArgumentException(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Player(input, 1);
                });
    }
}