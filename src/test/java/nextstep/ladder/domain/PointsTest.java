package nextstep.ladder.domain;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PointsTest {

    @Test
    void 연속된_점() {
        Points points = new Points(List.of(
                new Point(true),
                new Point(true)
        ));

        assertThat(points.isConsecutiveAt(0)).isTrue();
    }
    @Test
    void 연속된되지않은_점() {
        Points points = new Points(List.of(
                new Point(true),
                new Point(false)
        ));

        assertThat(points.isConsecutiveAt(0)).isFalse();
    }

    @Test
    void 벗어난_위치() {
        Points points = new Points(List.of(
                new Point(true),
                new Point(false)
        ));
        assertThatThrownBy(() -> points.isConsecutiveAt(-1))
                .isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> points.isConsecutiveAt(2))
                .isInstanceOf(RuntimeException.class);
    }
}