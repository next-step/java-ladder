package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DirectionTest {

    @Test
    @DisplayName("양쪽 모두 true 이면 예외 발생한다")
    void create_exception() {
        assertThatThrownBy(() -> Direction.of(true, true))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("left true 일 경우 오른쪽으로는 이동 못한다")
    void next_left_true() {
        // given
        Direction direction = Direction.of(false, true);
        Direction next = direction.next(() -> true);

        // when
        boolean isRight = next.isRight();

        // then
        assertThat(isRight).isFalse();
    }

    @Test
    @DisplayName("left 가 false 일 경우 오른쪽으로 이동 가능하다")
    void next_left_false() {
        // given
        Direction direction = Direction.of(false, false);
        Direction next = direction.next(() -> true);

        // when
        boolean isRight = next.isRight();

        // then
        assertThat(isRight).isTrue();
    }

    @Test
    @DisplayName("첫 Direction 생성하면 왼쪽으로는 이동 못한다")
    void first() {
        // given
        Direction first = Direction.first(false);

        // when
        boolean isLeft = first.isLeft();

        // then
        assertThat(isLeft).isFalse();
    }

    @Test
    @DisplayName("마지막 Direction 생성하면 오른쪽으로는 이동 못한다")
    void last() {
        // given
        Direction direction = Direction.of(false, true);
        Direction last = direction.last();

        // when
        boolean isRight = last.isRight();

        // then
        assertThat(isRight).isFalse();
    }
}
