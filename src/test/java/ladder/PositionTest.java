package ladder;

import ladder.model.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class PositionTest {
    @DisplayName("위치가 음수인 경우 예외가 발생한다")
    @Test
    void isPositive() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Position(-1));
    }
}
