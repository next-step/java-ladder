package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {
    @Test
    @DisplayName("LINE_TRUE 와 LINE_FALSE 는 각각 맞는 값을 갖고 있다.")
    void constructor() {
        assertThat(Line.of(true).hasLine()).isTrue();
        assertThat(Line.of(false).hasLine()).isFalse();
    }
}
