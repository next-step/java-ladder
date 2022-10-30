package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class DirectionTest {
    @Test
    @DisplayName("첫번째 방향은 언제나 왼쪽으로는 갈 수 없음")
    void first() {
        //given
        Direction first = Direction.first();
        //then
        assertThat(first.isLeft()).isFalse();
    }

    @Test
    @DisplayName("마지막 방향은 언제나 오른쪽으로는 갈 수 없음")
    void last() {
        //given
        Direction last = Direction.first().last();
        //then
        assertThat(last.isRight()).isFalse();
    }

    @Test
    @DisplayName("양 방향이 들어오면 오류")
    void left_and_right_all_same_time() {
        assertThatThrownBy(() -> Direction.of(true, true)).isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("방향이 아예 없으면 정상")
    void left_and_right_none_same_time() {
        assertThatNoException().isThrownBy(() -> Direction.of(false, false));
    }

    @Test
    @DisplayName("다음 방향을 만들때 이전 방향을 가져가는지 확인")
    void next() {
        //given
        Direction first = Direction.first();
        Direction next = first.next();
        //then
        assertThat(first.isRight()).isEqualTo(next.isLeft());
    }

    @Test
    @DisplayName("방향을 연달아서 안 만드는지 획인")
    void next_연달아() {
        //given
        Direction direction = Direction.of(false, true);
        Direction next = direction.next();
        //then
        assertAll(
                () -> assertThat(next.isRight()).isFalse(),
                () -> assertThat(next.isLeft()).isTrue()
        );

    }
}