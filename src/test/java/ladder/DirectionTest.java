package ladder;

import ladder.domain.Direction;
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
        Direction next = Direction.first().next();
        assertThat(next).isExactlyInstanceOf(Direction.of(TRUE, FALSE).getClass());
    }

    @Test
    public void next_random_false() {
        for (int i = 0; i < 100; i++) {
            Direction.first().next();
        }
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
        Direction first = Direction.first();
        assertThat(first.isLeft()).isEqualTo(FALSE);
    }

    @Test
    public void last() {
        Direction last = Direction.first().last();
        assertThat(last).isInstanceOf(Direction.of(TRUE, FALSE).getClass());
    }
}
