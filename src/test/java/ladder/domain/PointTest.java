package ladder.domain;


import ladder.domain.Ladder.Point;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @Test
    void is_equal_to_true() {
        Point point1 = new Point(true);
        Point point2 = new Point(true);
        Point point3 = new Point(false);
        Point point4 = new Point(false);

        assertThat(point1.isEqualToTrue(point2)).isTrue();
        assertThat(point1.isEqualToTrue(point3)).isFalse();
        assertThat(point3.isEqualToTrue(point4)).isFalse();
    }
}
