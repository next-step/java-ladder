package com.ladder.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
    @Test
    void whenBeforePointFalse_then_currentPoint_isDown() {
        //given
        int indexOfLadder = 1;
        Point expectedNextPoint = Point.of(indexOfLadder, Direction.DOWN);

        // when
        List<Point> points = this.pointsGenerator.generate(3, () -> false);
        Point nextPoint = points.get(indexOfLadder);

        // then
        assertThat(nextPoint).isEqualTo(expectedNextPoint);
    }

    @DisplayName("전 위치에서 오른쪽으로 이동하는 경우, 현 위치는 왼쪽으로 이동한다")
    @Test
    void whenBeforePointTrue_then_currentPoint_isLeft() {
        //given
        int indexOfLadder = 1;
        Point expectedNextPoint = Point.of(indexOfLadder, Direction.LEFT);

        // when
        List<Point> points = this.pointsGenerator.generate(3, () -> true);
        Point nextPoint = points.get(indexOfLadder);

        // then
        assertThat(nextPoint).isEqualTo(expectedNextPoint);
    }

    @DisplayName("마지막 위치는 왼쪽 또는 아래로 이동이 가능하다")
    @Test
    void lastPoint_isFalse_success() {
        // given
        Point expectedNextPoint = Point.of(2, Direction.DOWN);

        // when
        List<Point> points = this.pointsGenerator.generate(3, () -> true);
        Point lastPoint = points.get(points.size() - 1);

        // then
        assertThat(lastPoint).isEqualTo(expectedNextPoint);
    }
}