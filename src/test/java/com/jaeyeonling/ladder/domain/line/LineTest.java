package com.jaeyeonling.ladder.domain.line;

import com.jaeyeonling.ladder.domain.Fixture;
import com.jaeyeonling.ladder.domain.point.Direction;
import com.jaeyeonling.ladder.domain.point.Point;
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

    @DisplayName("Point가 STRAIGHT를 따라가면 indexOfLine만 1 증가한다.")
    @Test
    void should_increment_indexOfLine_when_ride_STRAIGHT() {
        // given
        final int indexOfLadder = 0;
        final int indexOfLine = 0;
        final Point point = Point.of(indexOfLadder, indexOfLine);

        // when
        final Point movedPoint = Fixture.allStraightLine.ride(point);

        // then
        assertThat(movedPoint).isEqualTo(Point.of(indexOfLadder, indexOfLine + 1));
    }

    @DisplayName("Point가 RIGHT를 따라가면 indexOfLine와 indexOfLadder가 1 증가한다.")
    @Test
    void should_increment_indexOfLine_and_indexOfLadder_when_ride_RIGHT() {
        // given
        final int indexOfLadder = 0;
        final int indexOfLine = 0;
        final Point point = Point.of(indexOfLadder, indexOfLine);

        // when
        final Point movedPoint = Fixture.rightLeftLine.ride(point);

        // then
        assertThat(movedPoint).isEqualTo(Point.of(indexOfLadder + 1, indexOfLine + 1));
    }

    @DisplayName("Point가 LEFT를 따라가면 indexOfLine가 1 증가하고 indexOfLadder가 1 감소한다.")
    @Test
    void should_increment_indexOfLine_and_decrement_indexOfLadder_when_ride_LEFT() {
        // given
        final int indexOfLadder = 1;
        final int indexOfLine = 1;
        final Point point = Point.of(indexOfLadder, indexOfLine);

        // when
        final Point movedPoint = Fixture.rightLeftLine.ride(point);

        // then
        assertThat(movedPoint).isEqualTo(Point.of(indexOfLadder - 1, indexOfLine + 1));
    }
}
