package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class HeightOfLadderTest {
    @Test
    @DisplayName("HeightOfLadder 인스턴스 생성시 height가 LADDER_MIN_HEIGHT보다 작은 경우 IllegalArgumentException이 발생합니다.")
    void testInstanceCreationFail() {
        int height = 0;
        assertThatThrownBy(() -> new HeightOfLadder(height)).isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
