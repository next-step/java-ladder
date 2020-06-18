package ladder;

import ladder.domain.Ladder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @DisplayName("사다리 높이 테스트")
    @Test
    void getLadderHeightSize() {
        assertThat(new Ladder(5, 2).getLineHeight()).isEqualTo(5);
    }
}
