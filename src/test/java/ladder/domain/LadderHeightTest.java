package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderHeightTest {
    @Test
    @DisplayName("LadderHeight 생성자 테스트")
    void constructor() {
        assertThat(new LadderHeight(1)).isEqualTo(new LadderHeight(1));
    }
}
