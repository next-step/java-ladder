package step2.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {
    @Test
    void createTest() {
        final Point previousPoint = new Point(true);
        final Point actual = new Point(previousPoint);
        final Point expected = new Point(false);
        assertThat(actual).isEqualTo(expected);
    }
}