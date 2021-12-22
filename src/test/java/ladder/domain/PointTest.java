package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    void right() {
        Point point = Point.of(0, Direction.first(true));
        assertThat(point.move()).isEqualTo(1);
    }

    @Test
    void left() {
        Point point = Point.of(1, Direction.first(true).next(false));
        assertThat(point.move()).isEqualTo(0);
    }
}
