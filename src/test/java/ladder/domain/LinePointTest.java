package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LinePointTest {
    @Test
    void testMoveLeft() {
        LinePoint linePoint = new LinePoint(1, Point.first(true).next(false));
        assertThat(linePoint.move()).isEqualTo(0);
    }

    @Test
    void testMoveRight() {
        LinePoint linePoint = new LinePoint(1, Point.first(false).next(true));
        assertThat(linePoint.move()).isEqualTo(2);
    }
}
