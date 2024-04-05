package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositionTest {

    @DisplayName("X축 또는 Y축이 음수인 경우 예외 발생")
    @Test
    void test01() {
        assertThatThrownBy(() -> new Position(-1, 0))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("좌표는 음수일 수 없습니다.");
    }
}
