package com.jaeyeonling.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointGenerateStrategyTest {

    @DisplayName("무조건 True를 리턴한다.")
    @Test
    void Create_True_Always() {
        final PointGenerateStrategy pointGenerateStrategy = () -> true;

        assertThat(pointGenerateStrategy.generate()).isTrue();
    }

    @DisplayName("무조건 False를 생성한다.")
    @Test
    void Create_False_Always() {
        final PointGenerateStrategy pointGenerateStrategy = () -> false;

        assertThat(pointGenerateStrategy.generate()).isFalse();
    }
}
