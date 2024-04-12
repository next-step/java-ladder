package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class FloorTest {
    @DisplayName("사다리 높이는 2보다 커야한다.")
    @Test
    void linesCount() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Floor(1);
        });
    }
}