package ladder_v2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @Test
    @DisplayName("Point는 true, false 값을 가질 수 있다.")
    void createPoint() {
        assertThat(Point.first().middle()).isInstanceOf(Point.class);
    }


}
