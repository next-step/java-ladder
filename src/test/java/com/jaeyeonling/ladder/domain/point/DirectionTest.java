package com.jaeyeonling.ladder.domain.point;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DirectionTest {

    @DisplayName("Direction.LEFT는 x다.")
    @Test
    void should_return_true_when_isX_of_LEFT() {
        // given
        final Direction direction = Direction.LEFT;

        // when
        final boolean isX = direction.isX();

        // then
        assertThat(isX).isTrue();
    }

    @DisplayName("Direction.RIGHT는 x다.")
    @Test
    void should_return_true_when_isX_of_RIGHT() {
        // given
        final Direction direction = Direction.RIGHT;

        // when
        final boolean isX = direction.isX();

        // then
        assertThat(isX).isTrue();
    }

    @DisplayName("Direction.LEFT는 y가 아니다.")
    @Test
    void should_return_false_when_isY_of_LEFT() {
        // given
        final Direction direction = Direction.LEFT;

        // when
        final boolean isY = direction.isY();

        // then
        assertThat(isY).isFalse();
    }

    @DisplayName("Direction.RIGHT는 y가 아니다.")
    @Test
    void should_return_false_when_isY_of_RIGHT() {
        // given
        final Direction direction = Direction.RIGHT;

        // when
        final boolean isY = direction.isY();

        // then
        assertThat(isY).isFalse();
    }

    @DisplayName("Direction.STRAIGHT는 y다.")
    @Test
    void should_return_true_when_isY_of_STRAIGHT() {
        // given
        final Direction direction = Direction.STRAIGHT;

        // when
        final boolean isY = direction.isY();

        // then
        assertThat(isY).isTrue();
    }

    @DisplayName("Direction.STRAIGHT는 x가 아니다.")
    @Test
    void should_return_false_when_isX_of_STRAIGHT() {
        // given
        final Direction direction = Direction.STRAIGHT;

        // when
        final boolean isX = direction.isX();

        // then
        assertThat(isX).isFalse();
    }


    @DisplayName("Direction.STAY는 x가 아니다.")
    @Test
    void should_return_false_when_isX_of_STAY() {
        // given
        final Direction direction = Direction.STAY;

        // when
        final boolean isX = direction.isX();

        // then
        assertThat(isX).isFalse();
    }

    @DisplayName("Direction.STAY는 y가 아니다.")
    @Test
    void should_return_false_when_isY_of_STAY() {
        // given
        final Direction direction = Direction.STAY;

        // when
        final boolean isY = direction.isY();

        // then
        assertThat(isY).isFalse();
    }
}
