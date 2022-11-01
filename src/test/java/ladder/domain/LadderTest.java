package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    @DisplayName("사다리의 높이만큼 사다리 라인의 개수가 만들어진다.")
    void createLadderTest_hasSize() {
        assertThat(new Ladder(4, new LadderHeight(5)).lines()).hasSize(5);
    }
}
