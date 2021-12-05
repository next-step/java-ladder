package nextstep.laddergame.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PointTest {

    @DisplayName("0, 1의 값으로 생성할 때 true, false로 생성되는지를 검증")
    @Test
    void numberConstructorTest() {
        assertThat(new Point(0)).isEqualTo(new Point(false));
        assertThat(new Point(1)).isEqualTo(new Point(true));
    }
}
