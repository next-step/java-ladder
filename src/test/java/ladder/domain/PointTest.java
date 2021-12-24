package ladder.domain;

import ladder.strategy.RandomGeneratorStrategy;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {
    @Test
    public void first() {
        assertThat(Point.first(previous -> true).move()).isEqualTo(1);
        assertThat(Point.first(previous -> false).move()).isEqualTo(0);
    }

    @Test
    public void next_stay() {
        Point second = Point.first(previous -> false).next(FALSE);
        assertThat(second.move()).isEqualTo(1);
    }

    @Test
    public void next_left() {
        Point second = Point.first(previous -> true).next(FALSE);
        assertThat(second.move()).isEqualTo(0);
    }

    @Test
    public void next_right() {
        Point second = Point.first(previous -> false).next(TRUE);
        assertThat(second.move()).isEqualTo(2);
    }

    @Test
    public void next() {
        Point second = Point.first(previous -> true).next(new RandomGeneratorStrategy());
        assertThat(second.move()).isEqualTo(0);
    }
}
