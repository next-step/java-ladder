package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

public class DirectionTest {
    @Test
    public void init() {
        assertThat(Direction.of(true, false))
                .isInstanceOf(Direction.class);
    }

    @Test
    public void init_invalid() {
        assertThatThrownBy(()->Direction.of(TRUE, TRUE))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void next_random_true() {
        Direction next = Direction.first(TRUE).next(FALSE);
        assertThat(next).isEqualTo(Direction.of(TRUE, FALSE));
    }

    @Test
    public void next_true() {
        Direction next = Direction.of(TRUE, FALSE).next(TRUE);
        assertThat(next).isEqualTo(Direction.of(FALSE, TRUE));
    }

    @Test
    @DisplayName("right가 true인 방향은 다음 방향을 생성할 때 right가 false인 방향만 생성한다.")
    public void next_true2() {
        Direction next = Direction.of(FALSE, TRUE).next(TRUE);
        assertThat(next).isEqualTo(Direction.of(TRUE, FALSE));
    }

    @Test
    public void next_false() {
        Direction next = Direction.of(FALSE, TRUE).next(FALSE);
        assertThat(next).isEqualTo(Direction.of(TRUE, FALSE));
    }

    @Test
    public void first() {
        Direction first = Direction.first(TRUE);
        assertAll(
                ()->assertFalse(first.isLeft()),
                ()->assertTrue(first.isRight())
        );
    }

    @Test
    public void last() {
        Direction last = Direction.first(TRUE).last();
        assertThat(last).isEqualTo(Direction.of(TRUE, FALSE));
    }
}