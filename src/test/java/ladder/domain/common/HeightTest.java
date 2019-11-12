package ladder.domain.common;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class HeightTest {

    @Test
    void 높이_만들기() {
        int value = 5;
        Height height = new Height(value);

        assertThat(height).isEqualTo(new Height(value));
    }

    @Test
    void 최소높이_불만족시() {
        int value = 0;
        assertThatThrownBy(() -> new Height(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}