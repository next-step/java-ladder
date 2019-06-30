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
        pointsGenerator = new PointsGenerator(() -> true);
    }

    @DisplayName("플레이어 수 만큼 위치를 생성하는데 성공한다")
    @Test
    void createPoint_countByPlayer_success() {
        // given
        int countByPlayers = 5;

        // when
        List<Boolean> points = pointsGenerator.generate(countByPlayers);

        // then
        assertThat(points).hasSize(countByPlayers);
    }

    @DisplayName("전 위치에서 이동가능 한 경우, 위치는 이동이 불가능하다.")
    @Test
    void whenBeforePointTrue_Then_currentPoint_isFalse() {
        // when
        List<Boolean> points = pointsGenerator.generate(5);
        boolean nextPoint = points.get(1);

        // then
        assertThat(nextPoint).isFalse();
    }

    @DisplayName("마지막 위치는 항상 이동이 불가능하다")
    @Test
    void lastPoint_isFalse_success() {
        // when
        List<Boolean> points = pointsGenerator.generate(5);
        boolean lastPoint = points.get(points.size() - 1);

        // then
        assertThat(lastPoint).isFalse();
    }
}