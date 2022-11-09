package ladder.ladder;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DirectionTest {
    @Test
    public void init() {
        assertThat(Direction.of(true, false)).isEqualTo(Direction.of(true, false));
    }

    @Test
    @DisplayName("양쪽이 연결되어 있는 것은 불가능하다.")
    public void init_invalid() {
        assertThatThrownBy(() -> Direction.of(TRUE, TRUE))
            .isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("현재 포인트에서 오른쪽이 연결되어 있으면 다음 포인트는 왼쪽으로 연결된다.")
    public void next_random_true() {
        Direction next = Direction.first(TRUE).next();
        assertThat(next).isEqualTo(Direction.of(TRUE, FALSE));
    }

    @Test
    @DisplayName("현재 포인트가 연결되어 있지 않으면 다음 포인트는 랜덤으로 연결이 결정된다.")
    public void next_random_false() {
        Direction next = Direction.first(FALSE).next();
        assertThat(next).isIn(Direction.of(FALSE, FALSE), Direction.of(FALSE, TRUE));
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
    @DisplayName("첫번쨰 포인트는 왼쪽이 FALSE")
    public void first() {
        Direction first = Direction.first(TRUE);
        assertThat(first.isLeft()).isFalse();
    }

    @Test
    @DisplayName("마지막 포인트는 오른쪽이 FALSE")
    public void last() {
        Direction last = Direction.first(TRUE).last();
        assertThat(last).isEqualTo(Direction.of(TRUE, FALSE));
    }
}
