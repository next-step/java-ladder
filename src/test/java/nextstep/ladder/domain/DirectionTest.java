package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class DirectionTest {
    @Test
    public void init() {
        assertThat(Direction.of(true, false)).isEqualTo(Direction.of(true, false));
    }

    @Test
    public void init_invalid() {
        assertThatThrownBy(() -> {
            Direction.of(TRUE, TRUE);
        }).isInstanceOf(IllegalStateException.class);
    }

    @Test
    public void next_random_true() {
        assertThat(Direction.first(TRUE).next(() -> true)).isEqualTo(Direction.of(TRUE, FALSE));
    }

//    @Test
//    public void next_random_false() {
//        for (int i = 0; i < 100; i++) {
//            Direction.first(FALSE).next(() -> true);
//        }
//    }

    @Test
    public void next_true() {
        assertThat(Direction.of(TRUE, FALSE).next(TRUE)).isEqualTo(Direction.of(FALSE, TRUE));
    }

    @Test
    public void next_false() {
        assertThat(Direction.of(FALSE, TRUE).next(FALSE)).isEqualTo(Direction.of(TRUE, FALSE));
    }

    @Test
    public void first() {
        assertThat(Direction.first(TRUE).isLeft()).isEqualTo(FALSE);
    }

    @Test
    public void last() {
        assertThat(Direction.first(TRUE).last()).isEqualTo(Direction.of(TRUE, FALSE));
    }
}
