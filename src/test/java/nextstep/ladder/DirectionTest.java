package nextstep.ladder;

import nextstep.ladder.domain.Direction2;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class DirectionTest {
    @Test
    public void init() {
        assertThat(Direction2.of(true, false)).isEqualTo(Direction2.of(true, false));
    }

    @Test
    public void init_invalid() {
        assertThatExceptionOfType(IllegalStateException.class).isThrownBy(() -> Direction2.of(TRUE, TRUE));
    }

    @Test
    public void next_random_true() {
        Direction2 next = Direction2.first(TRUE).next();
        assertThat(next).isEqualTo(Direction2.of(TRUE, FALSE));
    }

    @Test
    public void next_random_false() {
        for (int i = 0; i < 100; i++) {
            Direction2.first(FALSE).next();
        }
    }

    @Test
    public void next_true() {
        Direction2 next = Direction2.of(TRUE, FALSE).next(TRUE);
        assertThat(next).isEqualTo(Direction2.of(FALSE, TRUE));
    }

    @Test
    public void next_false() {
        Direction2 next = Direction2.of(FALSE, TRUE).next(FALSE);
        assertThat(next).isEqualTo(Direction2.of(TRUE, FALSE));
    }

    @Test
    public void first() {
        Direction2 first = Direction2.first(TRUE);
        assertThat(first.isLeft()).isEqualTo(FALSE);
    }

    @Test
    public void last() {
        Direction2 last = Direction2.first(TRUE).last();
        assertThat(last).isEqualTo(Direction2.of(TRUE, FALSE));
    }
}