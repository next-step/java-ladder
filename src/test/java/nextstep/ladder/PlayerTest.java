package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class PlayerTest {
    @Test
    @DisplayName(value = "참가자 객체 생성")
    void playerEquals() {
        assertThat(Player.of("jade", 0)
                .equals(Player.of("jade", 0)))
                .isEqualTo(true);
    }

    @ParameterizedTest
    @DisplayName(value = "객체 생성 예외")
    @CsvSource(value = {"'':0", "test12:0", "test:-1"}, delimiter = ':')
    void playerArgumentException(String input, int inputPosition) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Player.of(input, inputPosition);
                });
    }
}
