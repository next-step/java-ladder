package step4_ladderGame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DirectionTest {

    @DisplayName("prev의 값이 true 면 왼쪽으로 이동한다.")
    @Test
    void testCase1() {
        assertThat(Direction.valueOf(true, false)).isEqualTo(Direction.RIGHT);
    }

    @DisplayName("current의 값이 true 면 왼쪽으로 이동한다.")
    @Test
    void testCase2() {
        assertThat(Direction.valueOf(false, true)).isEqualTo(Direction.LEFT);
    }

    @DisplayName("prev와 current의 값이 false 면  정지한다.")
    @Test
    void testCase3() {
        assertThat(Direction.valueOf(false, false)).isEqualTo(Direction.STOP);
    }
}