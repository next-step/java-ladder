package ladder;

import ladder.domain.Point;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {
    private Point point;

    @BeforeEach
    void setUp() {
        point = new Point(Boolean.TRUE);
    }

    @Test
    void pointValueTest() {
        assertThat(point.getType()).isTrue();
    }

    @Test
    void pointConstructEqualTest() {
        assertThat(point).isEqualTo(new Point(Boolean.TRUE));
    }
}
