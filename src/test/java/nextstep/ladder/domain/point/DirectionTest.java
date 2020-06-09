package nextstep.ladder.domain.point;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class DirectionTest {

    @Test
    public void init_invalid() {
        assertThatThrownBy(() -> new Direction(true, true))
            .isInstanceOf(IllegalStateException.class);
    }

    @Test
    public void next_random_true() {
        Direction next = Direction.first(() -> true).next(() -> false);
        assertThat(next).isEqualTo(new Direction(true, false));
    }

    @Test
    public void next_true() {
        Direction next = new Direction(true, false).next(() -> true);
        assertThat(next).isEqualTo(new Direction(false, true));
    }

    @Test
    public void next_false() {
        Direction next = new Direction(false, true).next(() -> false);
        assertThat(next).isEqualTo(new Direction(true, false));
    }

    @Test
    public void first() {
        Direction first = Direction.first(() -> true);
        assertThat(first.isLeft()).isEqualTo(false);
    }

    @Test
    public void last() {
        Direction last = Direction.first(() -> false).last();
        assertThat(last).isEqualTo(new Direction(false, false));
    }

}
