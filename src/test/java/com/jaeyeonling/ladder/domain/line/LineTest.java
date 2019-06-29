package com.jaeyeonling.ladder.domain.line;

import com.jaeyeonling.ladder.domain.Fixture;
import com.jaeyeonling.ladder.domain.line.Line;
import com.jaeyeonling.ladder.domain.line.LineGenerator;
import com.jaeyeonling.ladder.domain.line.StrategyBaseLineGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @DisplayName("라인 생성을 성공한다.")
    @Test
    void should_create() {
        final LineGenerator lineGenerator = StrategyBaseLineGenerator.of(() -> true);

        final Line line = lineGenerator.generate(Fixture.countOfusers);

        assertThat(line).isNotNull();
    }

    @DisplayName("첫 라인과 앞 라인에 포인트가 있는 경우가 아니면 항상 포인트가 있다.")
    @Test
    void should_true_when_notFirst_and_notBeforeTrue() {
        final LineGenerator lineGenerator = StrategyBaseLineGenerator.of(() -> true);

        final Line line = lineGenerator.generate(Fixture.countOfusers);
        final List<Boolean> points = line.getPoints();
        for (int i = 2; i < points.size(); i++) {
            final Boolean before = points.get(i - 1);
            if (before) {
                assertThat(points.get(i)).isFalse();
            }
        }

        assertThat(line).isNotNull();
    }
}
