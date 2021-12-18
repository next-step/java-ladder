package ladder;

import ladder.domain.Height;
import ladder.exception.HeightException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HeightTest {

    @Test
    @DisplayName("사다리 높이는 숫자")
    void isHeightNumber() {
        Assertions.assertThatThrownBy(() -> Height.of("숫자아님")).isInstanceOf(NumberFormatException.class);
    }

    @Test
    @DisplayName("사다리 높이는 1이상")
    void heightIsOneMore() {
        Assertions.assertThatThrownBy(() -> Height.of("0")).isInstanceOf(HeightException.class);
    }
}
