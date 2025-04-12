package nextstep.ladder.module;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PointTest {

    @Test
    @DisplayName("x가 0 미만이면 에러")
    void givenXLessThanZero_whenCreatePoint_thenThrowException() {
        assertThatThrownBy(() -> new Point(-1, new Bridge())).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("x는 0 이상이어야 합니다.");
    }

    @Test
    @DisplayName("x가 0 이상이면 통과")
    void givenXGreaterThanOrEqualToZero_whenCreatePoint_thenPass() {
        assertThat(new Point(0, new Bridge()).value()).isEqualTo(0);
    }
}
