package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PointTest {

    @Test
    void pass() {
        Point point = Point.first(false);
        assertThat(point.selectDirection()).isEqualTo(Direction.PASS);
    }

    @Test
    void left() {
        Point point = Point.first(true).next(false);
        assertThat(point.selectDirection()).isEqualTo(Direction.LEFT);
    }

    @Test
    void right() {
        Point point = Point.first(true);
        assertThat(point.selectDirection()).isEqualTo(Direction.RIGHT);
    }
}
