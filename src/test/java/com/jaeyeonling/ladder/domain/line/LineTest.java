package com.jaeyeonling.ladder.domain.line;

import com.jaeyeonling.ladder.domain.Fixture;
import com.jaeyeonling.ladder.domain.point.Direction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @DisplayName("라인 생성을 성공한다.")
    @Test
    void should_create() {
        final LineGenerator lineGenerator = StrategyBaseLineGenerator.withStrategy(() -> true);

        final Line line = lineGenerator.generate(Fixture.countOfusers);

        assertThat(line).isNotNull();
    }

    @DisplayName("앞 방향이 RIGHT면 지금 방향은 LEFT이다.")
    @Test
    void should_true_when_notFirst_and_notBeforeTrue() {
        final LineGenerator lineGenerator = StrategyBaseLineGenerator.withStrategy(() -> true);

        final Line line = lineGenerator.generate(Fixture.countOfusers);
        final List<Direction> directions = line.getDirections();
        for (int i = 1; i < directions.size(); i++) {
            final Direction before = directions.get(i - Direction.DEFAULT_MOVING_DISTANCE_VALUE);
            if (before == Direction.RIGHT) {
                assertThat(directions.get(i)).isEqualTo(Direction.LEFT);
            }
        }
    }
}
