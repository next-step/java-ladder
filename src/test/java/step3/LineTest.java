package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {
    @Test
    @DisplayName("해당 위치가 옆으로 이동 가능한지 확인하는 메소드의 테스트")
    void hasSidelineAtTest() {
        Line line = new Line(() -> Arrays.asList(true, false, true));

        assertThat(line.hasSidelineAt(0)).isTrue();
        assertThat(line.hasSidelineAt(1)).isFalse();
    }

    @Test
    @DisplayName("Line 생성시 전달된 값의 범위를 넘어가는 경우 테스트")
    void hasSidelineAtExceptionTest() {
        Line line = new Line(() -> Arrays.asList(true, true));

        assertThat(line.hasSidelineAt(2)).isFalse();
    }
}
