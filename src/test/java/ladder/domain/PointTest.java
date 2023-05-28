package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PointTest {
    @Test
    @DisplayName("주어진 Direction 만큼 이동한 새로운 Point 객체를 반환한다.")
    void 이동후_point_반환() {
        Point point = new Point(0,0);
        assertThat(point.move(Direction.RIGHT)).isEqualTo(new Point(1,0));
    }
}
