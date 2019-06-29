package com.ladder.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class PointsGeneratorTest {

    private final int countByPlayers = 5;
    private final PointsGenerator pointsGenerator = new PointsGenerator(() -> true);
    private final List<Boolean> points = pointsGenerator.generate(countByPlayers);

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

    @DisplayName("전 위치가 true면 현 위치는 항상 false이다.")
    @Test
    void whenBeforePointTrue_Then_currentPoint_isFalse() {
        // when
        boolean nextPosition = points.get(1);
        // then
        assertThat(nextPosition).isFalse();
    }

    @DisplayName("마지막 위치는 항상 false 이다")
    @Test
    void lastPoint_isFalse_success() {
        // when
        boolean lastPosition = points.get(points.size() - 1);
        // then
        assertThat(lastPosition).isFalse();
    }
}