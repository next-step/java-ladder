package step2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HeightTest {

    @DisplayName("사다리 높이는 0보다 커야 한다.")
    @Test
    public void heightTest() {
        Assertions.assertThatThrownBy(() -> new Height(0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
