package ladder.domain.point;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DirectionTest {

    @ParameterizedTest
    @CsvSource({"true, 1", "false, 0"})
    void create_first(boolean current, int expect) {
        Direction direction = Direction.first(() -> current);

        assertThat(direction.move()).isEqualTo(expect);
    }

    @ParameterizedTest
    @CsvSource({"true, false, -1", "false, true, 1", "false, false, 0"})
    void create_next(boolean left, boolean current, int expect) {
        Direction direction = Direction.first(() -> left);
        direction = direction.next(() -> current);

        assertThat(direction.move()).isEqualTo(expect);
    }

    @ParameterizedTest
    @CsvSource({"true, -1", "false, 0"})
    void create_last(boolean left, int expect) {
        Direction direction = Direction.first(() -> left);
        direction = direction.last();

        assertThat(direction.move()).isEqualTo(expect);
    }

    @Test
    void of() {
        assertThat(Direction.of(true, false)).isEqualTo(Direction.BACK);
        assertThat(Direction.of(false, true)).isEqualTo(Direction.GO);
        assertThat(Direction.of(false, false)).isEqualTo(Direction.STAY);
    }

    @Test
    void of_invalidValue() {
        assertThatThrownBy(() -> Direction.of(true, true))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
