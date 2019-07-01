package com.jaeyeonling.ladder.domain.point;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DirectionTest {

    @DisplayName("Direction.LEFT는 x다.")
    @Test
    void should_return_true_when_isX_of_LEFT() {
        final Direction direction = Direction.LEFT;

        final boolean isX = direction.isX();

        assertThat(isX).isTrue();
    }

    @DisplayName("Direction.RIGHT는 x다.")
    @Test
    void should_return_true_when_isX_of_RIGHT() {
        final Direction direction = Direction.RIGHT;

        final boolean isX = direction.isX();

        assertThat(isX).isTrue();
    }

    @DisplayName("Direction.LEFT는 y가 아니다.")
    @Test
    void should_return_false_when_isY_of_LEFT() {
        final Direction direction = Direction.LEFT;

        final boolean isY = direction.isY();

        assertThat(isY).isFalse();
    }

    @DisplayName("Direction.RIGHT는 y가 아니다.")
    @Test
    void should_return_false_when_isY_of_RIGHT() {
        final Direction direction = Direction.RIGHT;

        final boolean isY = direction.isY();

        assertThat(isY).isFalse();
    }

    @DisplayName("Direction.STRAIGHT는 y다.")
    @Test
    void should_return_true_when_isY_of_STRAIGHT() {
        final Direction direction = Direction.STRAIGHT;

        final boolean isY = direction.isY();

        assertThat(isY).isTrue();
    }

    @DisplayName("Direction.STRAIGHT는 x가 아니다.")
    @Test
    void should_return_false_when_isX_of_STRAIGHT() {
        final Direction direction = Direction.STRAIGHT;

        final boolean isX = direction.isX();

        assertThat(isX).isFalse();
    }


    @DisplayName("Direction.STAY는 x가 아니다.")
    @Test
    void should_return_false_when_isX_of_STAY() {
        final Direction direction = Direction.STAY;

        final boolean isX = direction.isX();

        assertThat(isX).isFalse();
    }

    @DisplayName("Direction.STAY는 y가 아니다.")
    @Test
    void should_return_false_when_isY_of_STAY() {
        final Direction direction = Direction.STAY;

        final boolean isY = direction.isY();

        assertThat(isY).isFalse();
    }
}
