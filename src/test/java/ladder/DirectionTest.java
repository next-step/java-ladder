package ladder;

import ladder.domain.Direction;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class DirectionTest {

    @Test
    public void of_invalid_input() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            Direction.of(true, true);
        });
    }

    @Test
    public void of_right() {
        assertThat(Direction.of(true, false)).isEqualTo(Direction.RIGHT);
    }

    @Test
    public void of_left() {
        assertThat(Direction.of(false, true)).isEqualTo(Direction.LEFT);
    }

    @Test
    public void of_pass() {
        assertThat(Direction.of(false, false)).isEqualTo(Direction.PASS);
    }

    @Test
    public void next() {
        assertThat(Direction.LEFT.next(true)).isEqualTo(Direction.RIGHT);
    }

    @Test
    public void next_invalid_input() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            Direction.RIGHT.next(true);
        });
    }

    @Test
    public void last() {
        assertThat(Direction.RIGHT.last()).isEqualTo(Direction.LEFT);
    }
}
