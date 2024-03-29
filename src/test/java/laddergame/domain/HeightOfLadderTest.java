package laddergame.domain;

import laddergame.exception.InvalidHeightOfLadderException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class HeightOfLadderTest {
    @Test
    @DisplayName("HeightOfLadder 인스턴스 생성시 height가 LADDER_MIN_HEIGHT보다 작은 경우 InvalidHeightOfLadderException이 발생합니다.")
    void testInstanceCreationFail() {
        int height = 0;
        assertThatThrownBy(() -> HeightOfLadder.valueOf(height)).isExactlyInstanceOf(InvalidHeightOfLadderException.class);
    }
}
