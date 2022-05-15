package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class HeightTest {
    @Test
    @DisplayName("사다리의 높이는 0보다 작을 수 없다.")
    void validateHeight() {
        assertThatThrownBy(() -> new Height(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리의 높이는 1보다 작을 수 없습니다");
    }
}
