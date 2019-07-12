package com.jaeyeonling.ladder.domain.line;

import com.jaeyeonling.ladder.domain.Index;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class DirectionTest {

    @DisplayName("Right 일 경우 값을 증가시킨다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 34, 5, 6, 8, 8, 5675, 56, 54, 456, 45, 53, 5235, 412})
    void increment(final int rawPosition) {
        // given
        final Index index = Index.valueOf(rawPosition);

        // when
        final Index movedIndex = Direction.RIGHT.move(index);

        // then
        assertThat(movedIndex).isEqualTo(Index.valueOf(rawPosition + Index.INCREMENT_VALUE));
    }

    @DisplayName("Left 일 경우 값을 감소시킨다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 34, 5, 6, 8, 8, 5675, 56, 54, 456, 45, 53, 5235, 412})
    void decrement(final int rawPosition) {
        // given
        final Index index = Index.valueOf(rawPosition);

        // when
        final Index movedIndex = Direction.LEFT.move(index);

        // then
        assertThat(movedIndex).isEqualTo(Index.valueOf(rawPosition - Index.INCREMENT_VALUE));
    }

    @DisplayName("Straight 일 경우 값은 그대로다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 34, 5, 6, 8, 8, 5675, 56, 54, 456, 45, 53, 5235, 412})
    void stay(final int rawPosition) {
        // given
        final Index index = Index.valueOf(rawPosition);

        // when
        final Index movedIndex = Direction.STRAIGHT.move(index);

        // then
        assertThat(movedIndex).isEqualTo(index);
    }

    @DisplayName("첫 방향을 Right 로 생성한다.")
    @Test
    void firstRight() {
        // given
        final DirectionGenerateStrategy strategy = () -> true;

        // when
        final Direction direction = Direction.first(strategy);

        // then
        assertThat(direction).isEqualTo(Direction.RIGHT);
    }

    @DisplayName("첫 방향을 Straight 로 생성한다.")
    @Test
    void firstStraight() {
        // given
        final DirectionGenerateStrategy strategy = () -> false;

        // when
        final Direction direction = Direction.first(strategy);

        // then
        assertThat(direction).isEqualTo(Direction.STRAIGHT);
    }

    @DisplayName("앞 방향이 Right 인 경우 다음 방향은 Left 다.")
    @Test
    void beforeRight_nextLeft() {
        // given
        final DirectionGenerateStrategy strategy = () -> true;
        final Direction before = Direction.first(strategy);

        // when
        final Direction next = before.next(strategy);

        // then
        assertThat(next).isEqualTo(Direction.LEFT);
    }

    @DisplayName("앞 방향이 Straight 인 경우 다음 방향을 Right 로 생성한다.")
    @Test
    void beforeStraight_nextRight() {
        // given
        final Direction before = Direction.first(() -> false);

        // when
        final Direction next = before.next(() -> true);

        // then
        assertThat(next).isEqualTo(Direction.RIGHT);
    }

    @DisplayName("앞 방향이 Straight 인 경우 다음 방향을 Straight 로 생성한다.")
    @Test
    void beforeStraight_nextStraight() {
        // given
        final Direction before = Direction.first(() -> false);

        // when
        final Direction next = before.next(() -> false);

        // then
        assertThat(next).isEqualTo(Direction.STRAIGHT);
    }

    @DisplayName("앞 방향이 Right 인 경우 마지막 방향을 Left 로 생성한다.")
    @Test
    void beforeRight_last() {
        // given
        final Direction before = Direction.first(() -> true);

        // when
        final Direction last = before.last();

        // then
        assertThat(last).isEqualTo(Direction.LEFT);
    }

    @DisplayName("앞 방향이 Straight 인 경우 마지막 방향을 Straight 로 생성한다.")
    @Test
    void beforeStraight_last() {
        // given
        final Direction before = Direction.first(() -> false);

        // when
        final Direction last = before.last();

        // then
        assertThat(last).isEqualTo(Direction.STRAIGHT);
    }
}
