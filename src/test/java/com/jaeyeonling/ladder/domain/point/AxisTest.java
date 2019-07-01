package com.jaeyeonling.ladder.domain.point;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AxisTest {

    @DisplayName("Axis X는 x다.")
    @Test
    void should_return_true_when_isX_of_AxisX() {
        final Axis axis = Axis.X;

        final boolean isX = axis.isX();

        assertThat(isX).isTrue();
    }

    @DisplayName("Axis X는 y가 아니다.")
    @Test
    void should_return_false_when_isY_of_AxisX() {
        final Axis axis = Axis.X;

        final boolean isY = axis.isY();

        assertThat(isY).isFalse();
    }

    @DisplayName("Axis Y는 y다.")
    @Test
    void should_return_true_when_isY_of_AxisY() {
        final Axis axis = Axis.X;

        final boolean isY = axis.isY();

        assertThat(isY).isFalse();
    }

    @DisplayName("Axis Y는 x가 아니다.")
    @Test
    void should_return_false_when_isX_of_AxisY() {
        final Axis axis = Axis.X;

        final boolean isX = axis.isX();

        assertThat(isX).isTrue();
    }
}
