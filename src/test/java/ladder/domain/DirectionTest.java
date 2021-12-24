package ladder.domain;

import ladder.strategy.RandomGeneratorStrategy;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DirectionTest {
    private static final Direction STAY = new Direction.Builder().left(FALSE).right(FALSE).build();
    private static final Direction LEFT = new Direction.Builder().left(TRUE).right(FALSE).build();
    private static final Direction RIGHT = new Direction.Builder().left(FALSE).right(TRUE).build();
    @Test
    public void init() {
        assertThat(new Direction.Builder().build()).isEqualTo(STAY);
    }

    @Test
    public void init_invalid() {
        assertThatThrownBy(() -> new Direction.Builder().left(TRUE).right(TRUE).build())
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    public void next_random_true() {
        Direction next = Direction.first(previous -> true).next(new RandomGeneratorStrategy());
        assertThat(next).isEqualTo(LEFT);
    }

    @Test
    public void next_true() {
        Direction next = LEFT.next(TRUE);
        assertThat(next).isEqualTo(RIGHT);
    }

    @Test
    public void next_false() {
        Direction next = RIGHT.next(FALSE);
        assertThat(next).isEqualTo(LEFT);
    }

    @Test
    public void first() {
        Direction first = Direction.first(previous -> true);
        assertThat(first.isLeft()).isEqualTo(FALSE);
    }

    @Test
    public void last() {
        Direction last = Direction.first(previous -> true).last();
        assertThat(last).isEqualTo(LEFT);
    }
}