package ladder;

import ladder.domain.Direction;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class DirectionTest {

    @Test
    public void init() {
        assertThat(Direction.of(TRUE, FALSE)).isEqualTo(Direction.of(TRUE, FALSE));
    }

    @Test
    public void init_invalid() {
        assertThatIllegalStateException().isThrownBy(() ->
                Direction.of(TRUE, TRUE)
        );
    }

    @Test
    public void next_random_true() {
        Direction next = Direction.first(TRUE).next();
        assertThat(next).isEqualTo(Direction.of(TRUE, FALSE));
    }

    @Test
    public void next_random_false() {
        for (int i = 0; i < 100; i++) {
            Direction.first(FALSE).next();
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
        Direction first = Direction.first(TRUE);
        assertThat(first.isLeft()).isFalse();
    }

    @Test
    public void last() {
        Direction last = Direction.first(TRUE).last();
        assertThat(last).isEqualTo(Direction.of(TRUE, FALSE));
    }
}
