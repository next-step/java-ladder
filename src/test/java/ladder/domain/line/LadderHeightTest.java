package ladder.domain.line;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderHeightTest {

    @DisplayName("최대 사다리 높이보다 높으면 IllegalArgumentException")
    @Test
    void maxHeight() {
        assertThatThrownBy(() -> LadderHeight.of(10))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("최소 사다리 높이보다 낮으면 IllegalArgumentException")
    @Test
    void minHeight() {
        assertThatThrownBy(() -> LadderHeight.of(0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
