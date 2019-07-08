package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DirectionTest {

    @Test
    @DisplayName("맨 앞에 나오는 경우 왼쪽으로 이어질 수 없음")
    void first_connected() {
        this.testFirst(true, Direction.RIGHT);
    }

    @Test
    @DisplayName("맨 앞에 나오는 경우 왼쪽으로 이어질 수 없음")
    void first_not_connected() {
        this.testFirst(false, Direction.NONE);
    }

    private void testFirst(final boolean isConnected, final Direction expected) {
        final Direction direction = Direction.first(isConnected);
        assertThat(direction).isEqualTo(expected);
    }

    @Test
    @DisplayName("이전의 Point 가 오른쪽으로 이어져있으면 다음 Point 는 왼쪽으로 이어져야함")
    void next_connected_to_left() {
        this.testNext(true, Direction.LEFT);
    }

    @Test
    @DisplayName("이전의 Point 가 오른쪽으로 이어져있으면 다음 Point 는 입력값과 상관없이 왼쪽으로 이어져야함")
    void next__given_not_connected__but_connected_with_left() {
        this.testNext(false, Direction.LEFT);
    }

    private void testNext(final boolean isConnected, final Direction expected) {
        final Direction first = Direction.first(true);
        final Direction next = first.next(isConnected);
        assertThat(next).isEqualTo(expected);
    }

    @Test
    @DisplayName("이전의 Point 가 왼쪽으로 이어져있으면 다음 Point 는 입력값대로 이어져야함")
    void next_connected_to_right() {
        // given
        final Direction first = Direction.first(true);
        final Direction second = first.next(true);
        // when
        final Direction actual = second.next(true);
        // then
        assertThat(actual).isEqualTo(Direction.RIGHT);
    }

    @Test
    @DisplayName("이전의 Point 가 왼쪽으로 이어져있으면 다음 Point 는 입력값대로 이어져야함")
    void next_not_connected() {
        // given
        final Direction first = Direction.first(true);
        final Direction second = first.next(true);
        // when
        final Direction actual = second.next(false);
        // then
        assertThat(actual).isEqualTo(Direction.NONE);
    }

    @Test
    @DisplayName("마지막 직전의 Direction 이 LEFT 이면, 마지막 Direction 은 NONE 이어야함")
    void last_not_connected1() {
        // given
        final Direction first = Direction.first(true);
        final Direction second = first.next(true);
        // when
        final Direction actual = second.last();
        // then
        assertThat(actual).isEqualTo(Direction.NONE);
    }

    @Test
    @DisplayName("마지막 직전의 Direction 이 NONE 이면, 마지막 Direction 도 NONE 이어야함")
    void last_not_connected2() {
        // given
        final Direction first = Direction.first(false);
        // when
        final Direction actual = first.last();
        // then
        assertThat(actual).isEqualTo(Direction.NONE);
    }

    @Test
    @DisplayName("마지막 직전의 Direction 이 RIGHT 이면, 마지막 Direciton 은 LEFT 이어야함")
    void last_connected() {
        // given
        final Direction first = Direction.first(true);
        // when
        final Direction actual = first.last();
        // then
        assertThat(actual).isEqualTo(Direction.LEFT);
    }
}