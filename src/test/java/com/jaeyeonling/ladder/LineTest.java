package com.jaeyeonling.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @DisplayName("라인 생성을 성공한다.")
    @Test
    void should_create() {
        final LineGenerator lineGenerator = StrategyBaseLineGenerator.of(() -> true);

        final Line line = lineGenerator.generate(Fixture.countOfusers);

        assertThat(line).isNotNull();
    }
}
