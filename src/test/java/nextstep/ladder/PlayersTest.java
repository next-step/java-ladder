package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class PlayersTest {
    @ParameterizedTest
    @DisplayName(value = "참가자 수 객체 생성 예외")
    @ValueSource(strings = {"AAA", ""})
    void playerArgumentException(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Players.from(input);
                });
    }
}
