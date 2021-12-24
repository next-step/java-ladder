package ladder.domain;

import ladder.strategy.RandomGeneratorStrategy;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DirectionTest {
    @Test
    public void init() {
        assertThat(Direction.of(true, false)).isEqualTo(Direction.of(true, false));
    }

    @Test
    public void init_invalid() {
        assertThatThrownBy(() -> Direction.of(TRUE, TRUE))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    public void next_random_true() {
        Direction next = Direction.first(previous -> true).next(new RandomGeneratorStrategy());
        assertThat(next).isEqualTo(Direction.of(TRUE, FALSE));
    }

    @Test
    public void next_true() {
        Direction next = Direction.of(TRUE, FALSE).next(TRUE);
        assertThat(next).isEqualTo(Direction.of(FALSE, TRUE));
    }

    @Test
    public void next_false() {
        Direction next = Direction.of(FALSE, TRUE).next(FALSE);
        assertThat(next).isEqualTo(Direction.of(TRUE, FALSE));
    }

    @Test
    public void first() {
        Direction first = Direction.first(previous -> true);
        assertThat(first.isLeft()).isEqualTo(FALSE);
    }

    @Test
    public void last() {
        Direction last = Direction.first(previous -> true).last();
        assertThat(last).isEqualTo(Direction.of(TRUE, FALSE));
    }
}