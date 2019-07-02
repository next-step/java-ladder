package com.ladder.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.ladder.model.Point.POINT_DOWN;
import static com.ladder.model.Point.POINT_LEFT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PointsGeneratorTest {

    private PointsGenerator pointsGenerator;

    @BeforeEach
    void setUp() {
        pointsGenerator = new PointsGenerator();
    }

    @DisplayName("플레이어 수 만큼 위치를 생성하는데 성공한다")
    @Test
    void createPoint_countByPlayer_success() {
        // given
        int countByPlayers = 5;

        // when
        List<Point> points = this.pointsGenerator.generate(countByPlayers, () -> true);

        // then
        assertThat(points).hasSize(countByPlayers);
    }

    @DisplayName("전 위치에서 오른쪽으로 이동하지 않는 경우, 현 위치는 아래로 이동한다")
    @ParameterizedTest
    @MethodSource("pointStrategyAndResultPointProvider")
    void whenBeforePointFalse_then_currentPoint_isDown() {
        //given
        Point expectedNextPoint = POINT_DOWN;

        // when
        List<Point> points = this.pointsGenerator.generate(3, () -> false);
        Point nextPoint = points.get(1);

        // then
        assertThat(nextPoint).isEqualTo(expectedNextPoint);
    }

    @DisplayName("전 위치에서 오른쪽으로 이동하는 경우, 현 위치는 왼쪽으로 이동한다")
    @Test
    void whenBeforePointTrue_then_currentPoint_isLeft() {
        //given
        Point expectedNextPoint = POINT_LEFT;

        // when
        List<Point> points = this.pointsGenerator.generate(3, () -> true);
        Point nextPoint = points.get(1);

        // then
        assertThat(nextPoint).isEqualTo(expectedNextPoint);
    }

    @DisplayName("마지막 위치는 왼쪽 또는 아래로 이동이 가능하다")
    @ParameterizedTest
    @MethodSource("pointStrategyAndResultPointProvider")
    void lastPoint_isFalse_success(Boolean beforePoint, Point expectedLastPoint) {
        // when
        List<Point> points = this.pointsGenerator.generate(3, () -> beforePoint);
        Point lastPoint = points.get(points.size() - 1);

        // then
        assertThat(lastPoint).isEqualTo(expectedLastPoint);
    }

    private static Stream<Arguments> pointStrategyAndResultPointProvider() {
        return Stream.of(
                arguments(true, POINT_LEFT),
                arguments(false, POINT_DOWN)
        );
    }
}