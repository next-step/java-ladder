package step4_ladderGame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PointTest {

    @DisplayName("Point의 이전값과 현재값이 둘다 true일 수 없다.")
    @Test
    void testCase1() {
        assertThatThrownBy(() -> {
            Point.of(true, true);
        }).isInstanceOf(IllegalArgumentException.class);
    }


}