package nextstep.ladder.module;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PointTest {

    @Test
    @DisplayName("x가 0 미만이면 에러")
    void givenNegativePosition_whenCreatePoint_thenThrowException() {
        assertThatThrownBy(() -> new Point(-1, new LeftBridge())).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("x는 0 이상이어야 합니다.");
    }

    @Test
    @DisplayName("x가 0 이상이면 통과")
    void givenPosition_whenCreatePoint_thenReturnValue() {
        assertThat(new Point(0, new LeftBridge()).value()).isEqualTo(0);
    }

    @Test
    @DisplayName("양쪽에 연속된 사다리가 있으면 안됨")
    void givenLineWithConsecutiveBridges_whenCreateLine_thenThrowException() {
        Point point = new Point(1);
        point.createLeftBridge();

        assertThatThrownBy(() -> point.createRightBridge()).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Point에서 양쪽 사다리가 있으면 안됩니다.");
    }
}
