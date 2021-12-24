package ladder.domain;

import ladder.strategy.RandomGeneratorStrategy;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {
    @Test
    public void first() {
        assertThat(Point.first(previous -> true).move()).isEqualTo(1);
        assertThat(Point.first(previous -> false).move()).isEqualTo(0);
    }

    @Test
    public void next() {
        Point second = Point.first(previous -> true).next(new RandomGeneratorStrategy());
        assertThat(second.move()).isEqualTo(0);
    }
}
