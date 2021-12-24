package ladder.domain;

import ladder.strategy.RandomGeneratorStrategy;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {
    @Test
    public void first() {
        assertThat(Point.first(() -> true).move()).isEqualTo(1);
        assertThat(Point.first(() -> false).move()).isEqualTo(0);
    }

    @Test
    public void next() {
        Point second = Point.first(() -> true).next(new RandomGeneratorStrategy());
        assertThat(second.move()).isEqualTo(0);
    }
}
