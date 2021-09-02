package ladder.domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PointTest {

    @Test
    @DisplayName("Point 객체는 본인의 위치와 연결된 point참조값을 가진다.")
    void pointCreateTest() {

        // given
        int position = 2;

        // when
        Point point = new Point(2);

        // then
        assertThat(point.position()).isEqualTo(position);
        assertThat(point.linkPoint().orElse(null)).isNull();
    }

}