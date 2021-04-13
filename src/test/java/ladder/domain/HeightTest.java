package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class HeightTest {

    @Test
    @DisplayName("사다리 최소 높이가 1일때 1보다 작게 입력하면 예외 발생한다")
    void validate_min_height() {
        assertThatThrownBy(() -> Height.from(0))
                .isInstanceOf(RuntimeException.class);
    }
}