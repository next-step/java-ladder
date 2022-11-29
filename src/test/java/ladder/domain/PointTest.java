package ladder.domain;

import ladder.strategy.RandomLineCreateStrategy;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

class PointTest {
    @Test
    void first() {
        assertThat(Point.first(TRUE).move()).isEqualTo(1);
        assertThat(Point.first(FALSE).move()).isZero();
    }

    @Test
    void next_stay() {
        Point second = Point.first(FALSE).next(FALSE);
        assertThat(second.move()).isEqualTo(1);
    }

    @Test
    void next_left() {
        Point second = Point.first(TRUE).next(FALSE);
        assertThat(second.move()).isZero();
    }

    @Test
    void next_right() {
        Point second = Point.first(FALSE).next(TRUE);
        assertThat(second.move()).isEqualTo(2);
    }

    @Test
    void next() {
        Point second = Point.first(TRUE).next(new RandomLineCreateStrategy());
        assertThat(second.move()).isZero();
    }
}
