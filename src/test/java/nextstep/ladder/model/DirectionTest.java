package nextstep.ladder.model;

import nextstep.ladder.exception.TwoWayDirectionException;
import nextstep.ladder.model.ladder.Direction;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DirectionTest {

    @Test
    void init() {
        assertThat(Direction.of(TRUE, FALSE)).isEqualTo(Direction.of(TRUE, FALSE));
    }

    @Test()
    void init_exception() {
        assertThatThrownBy(() -> Direction.of(TRUE, TRUE)).isExactlyInstanceOf(TwoWayDirectionException.class);
    }

    @Test
    void next_random_true() {
        assertThat(Direction.first(TRUE).next()).isEqualTo(Direction.of(TRUE, FALSE));
    }

    @Test
    void next_random_false() {
        IntStream.range(0, 100)
                .forEach(i -> Direction.first(FALSE).next());
    }

    @Test
    void next_true() {
        assertThat(Direction.of(TRUE, FALSE).next(TRUE)).isEqualTo(Direction.of(FALSE, TRUE));
    }

    @Test
    void next_false() {
        assertThat(Direction.of(FALSE, TRUE).next(FALSE)).isEqualTo(Direction.of(TRUE, FALSE));
    }

    @Test
    void first() {
        assertThat(Direction.first(TRUE)).isEqualTo(Direction.of(FALSE, TRUE));
    }

    @Test
    void last() {
        assertThat(Direction.first(TRUE).last()).isEqualTo(Direction.of(TRUE, FALSE));
    }
}
