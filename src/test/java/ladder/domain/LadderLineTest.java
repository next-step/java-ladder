package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderLineTest {
    int ladderSize = 4;

    @Test
    @DisplayName("init 을 통해 LadderLine 을 생성할 수 있다")
    void init() {
        LadderLine ladderLine = LadderLine.init(ladderSize);
        assertThat(ladderLine.size()).isEqualTo(ladderSize);
    }
}
