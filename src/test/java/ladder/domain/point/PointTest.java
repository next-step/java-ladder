package ladder.domain.point;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @Test
    void create() {
        Point point = Point.valueOf(true);

        assertThat(point).isEqualTo(Point.strategyOf(() -> true));
    }

    @Test
    void isPoint() {
        Point point = Point.valueOf(false);

        assertThat(point.isPoint()).isFalse();
    }
}