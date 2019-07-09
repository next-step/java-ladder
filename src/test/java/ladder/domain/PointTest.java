package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    void first() {
        Point point = Point.first(true).move();
        assertThat(point.getPosition()).isEqualTo(1);
    }

}
