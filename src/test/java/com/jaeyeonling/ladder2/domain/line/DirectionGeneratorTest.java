package com.jaeyeonling.ladder2.domain.line;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DirectionGeneratorTest {

    @DisplayName("True 만 생성한다.")
    @Test
    void onlyTrue() {
        // given
        final DirectionGenerateStrategy strategy = () -> true;

        // when
        final Boolean generated = strategy.generate();

        // then
        assertThat(generated).isTrue();
    }

    @DisplayName("false 만 생성한다.")
    @Test
    void onlyFalse() {
        // given
        final DirectionGenerateStrategy strategy = () -> false;

        // when
        final Boolean generated = strategy.generate();

        // then
        assertThat(generated).isFalse();
    }
}
