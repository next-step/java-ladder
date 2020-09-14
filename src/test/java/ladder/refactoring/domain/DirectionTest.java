package ladder.refactoring.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DirectionTest {

    @Test
    void creation_test() {
        Direction direction = Direction.of(false, true);
        assertThat(direction.equals(Direction.of(false, true))).isTrue();
    }

    @Test
    void exception_test() {
        assertThatThrownBy(() -> Direction.of(true, true)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void move_test() {
        Direction left = Direction.of(true, false);
        Direction right = Direction.of(false, true);
        Direction stay = Direction.of(false, false);

        assertThat(left.orient()).isEqualTo(-1);
        assertThat(right.orient()).isEqualTo(1);
        assertThat(stay.orient()).isEqualTo(0);
    }

    @Test
    void next_test() {
        Direction direction = Direction.of(false, true);
        assertThat(direction.next()).isEqualTo(Direction.of(true, false));
    }

    @Test
    void last_test() {
        Direction direction = Direction.of(true, false);
        assertThat(Direction.of(false, true).last()).isEqualTo(direction);
    }
}
