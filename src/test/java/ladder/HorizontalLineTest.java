package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HorizontalLineTest {
    @Test
    @DisplayName("LINE_TRUE 와 LINE_FALSE 는 각각 맞는 값을 갖고 있다.")
    void constructor() {
        assertThat(HorizontalLine.LINE_TRUE.hasLine()).isTrue();
        assertThat(HorizontalLine.LINE_FALSE.hasLine()).isFalse();
    }
}
