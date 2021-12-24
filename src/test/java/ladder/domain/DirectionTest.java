package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {

    @Test
    public void first() {
        Direction next = Direction.first(() -> true);
        assertThat(next).isNotEqualByComparingTo(Direction.LEFT);
    }

    @Test
    public void next() {
        Direction next = Direction.first(() -> true).next(() -> true);
        assertThat(next).isEqualTo(Direction.LEFT);
    }

    @Test
    public void last() {
        Direction last = Direction.first(() -> true).last();
        assertThat(last).isNotEqualByComparingTo(Direction.RIGHT);
    }
}