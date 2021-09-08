package step2.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class HeightTest {
    private static final int MIN_LIMIT = 0;

    @Test
    void createHeightFailTest() {
        assertThatThrownBy(() -> new Height(-1))
                .isExactlyInstanceOf(RuntimeException.class)
                .hasMessage(String.format("사다리 높이는 %d 보다 작을 수 없습니다", MIN_LIMIT));
    }

    @Test
    void createHeightSuccessTest() {
        final Height height = new Height(1);
        assertThat(height).isEqualTo(new Height(1));
    }
}