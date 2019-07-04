package ladder.engine.impl;

import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class DirectionTest {
    @Test
    public void init() {
        assertThat(Direction.of(true, false)).isEqualTo(Direction.of(true, false));
    }

    @Test
    public void init_invalid() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Direction.of(TRUE, TRUE);
        });
    }

    @Test
    public void next_random_true() {
        Direction next = Direction.first(TRUE).next();
        assertThat(next).isEqualTo(Direction.of(TRUE, FALSE));
    }

    @Test
    public void move_left() {
        Direction direction = Direction.of(TRUE, FALSE);
        assertThat(direction.move()).isEqualTo(-1);
    }

    @Test
    public void move_right() {
        Direction direction = Direction.of(FALSE, TRUE);
        assertThat(direction.move()).isEqualTo(1);
    }

    @Test
    public void move_straight() {
        Direction direction = Direction.of(FALSE, FALSE);
        assertThat(direction.move()).isEqualTo(0);
    }

    @Test
    public void next_false() {
        Direction next = Direction.of(FALSE, TRUE).next(FALSE);
        assertThat(next).isEqualTo(Direction.of(TRUE, FALSE));
    }

    @Test
    public void first() {
        Direction first = Direction.first(TRUE);
        assertThat(first).isEqualTo(Direction.of(FALSE, TRUE));
    }

    @Test
    public void last() {
        Direction last = Direction.first(TRUE).last();
        assertThat(last).isEqualTo(Direction.of(TRUE, FALSE));
    }
}
