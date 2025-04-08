package nextstep.ladder.domain;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @Test
    void 점_유무() {
        Point point = new Point(false);
        assertThat(point.isPresent()).isFalse();
    }

    @Test
    void 연속되지않은_점() {
        Point point1 = new Point(true);
        Point point2 = new Point(false);
        assertThat(point1.isConsecutive(point2)).isFalse();
    }

    @Test
    void 연속된_점() {
        Point point1 = new Point(true);
        Point point2 = new Point(true);
        assertThat(point1.isConsecutive(point2)).isTrue();
    }
}