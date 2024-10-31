package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PointTest {

    @Test
    void 위치_저장_테스트() {
        Point point = new Point(1);

        assertThat(point).isEqualTo(new Point("1"));
    }

    @Test
    void 위치_저장_실패_테스트() {
        assertThatThrownBy(() -> new Point(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("위치는 0보다 작을 수 없습니다.");
    }

}
