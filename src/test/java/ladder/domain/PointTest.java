package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {
    @Test
    @DisplayName("좌표 생성")
    void create() {
        // given
        int position = 0;
        Point point = new Point(false, false);

        // when
        assertThat(point).isEqualTo(new Point(false, false));
    }

}