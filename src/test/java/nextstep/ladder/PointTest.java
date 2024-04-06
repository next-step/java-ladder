package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PointTest {

    @DisplayName("좌 우 모두 이동 가능한 Point는 생성할 수 없다")
    @Test
    void create() {
        assertThatThrownBy(() -> new Point(true, true))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
