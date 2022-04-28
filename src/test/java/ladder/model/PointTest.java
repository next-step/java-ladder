package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @Test
    @DisplayName("index 와 direction 을 입력하면 객체를 생성한다")
    void of() {
        assertThat(Point.of(1, Direction.of(true, true))).isInstanceOf(Point.class);
    }

}