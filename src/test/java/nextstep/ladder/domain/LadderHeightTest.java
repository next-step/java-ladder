package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderHeightTest {
    @Test
    @DisplayName("성공 - getValue메서드가 value를 반환한다.")
    void initLadderTest() {
        LadderHeight height = new LadderHeight(1);
        assertThat(height.getValue()).isEqualTo(1);
    }
}