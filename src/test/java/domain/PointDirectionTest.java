package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static domain.PointDirection.*;
import static org.assertj.core.api.Assertions.*;


class PointDirectionTest {

    @Test
    @DisplayName("PointDirection.LEFT의 operate 호출 시 매개변수 -1 반환")
    void left() {
        assertThat(LEFT.operate(1)).isEqualTo(0);
    }

    @Test
    @DisplayName("PointDirection.RIGHT의 operate 호출 시 매개변수 +1 반환")
    void right() {
        assertThat(RIGHT.operate(1)).isEqualTo(2);
    }

    @Test
    @DisplayName("PointDirection.NONE의 operate 호출 시 매개변수 그대로 반환")
    void none() {
        assertThat(NONE.operate(1)).isEqualTo(1);
    }


}