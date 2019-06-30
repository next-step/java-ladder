package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HorizontalLineTest {
    @Test
    @DisplayName("최초 생성시에는 hasLine 이 false 이다")
    void constructor() {
        HorizontalLine horizontalLine = new HorizontalLine();
        assertThat(horizontalLine.hasLine()).isFalse();
    }
}
