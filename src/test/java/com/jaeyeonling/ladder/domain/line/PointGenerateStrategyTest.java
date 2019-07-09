package com.jaeyeonling.ladder.domain.line;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointGenerateStrategyTest {

    @DisplayName("무조건 True를 리턴한다.")
    @Test
    void should_return_true_always_when_generate_by_trueStrategy() {
        final PointGenerateStrategy pointGenerateStrategy = () -> true;

        assertThat(pointGenerateStrategy.generate()).isTrue();
    }

    @DisplayName("무조건 False를 생성한다.")
    @Test
    void should_return_false_always_when_generate_by_falseStrategy() {
        final PointGenerateStrategy pointGenerateStrategy = () -> false;

        assertThat(pointGenerateStrategy.generate()).isFalse();
    }
}
