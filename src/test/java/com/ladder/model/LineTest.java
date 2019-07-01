package com.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @DisplayName("랜덤한 위치를 갖는 한 개의 라인을 생성한다")
    @Test
    void createLine_success() {
        // given
        int numberOfPlayers = 5;

        // when
        Line points = Line.of(numberOfPlayers);

        // then
        assertThat(points).isNotNull();
        assertThat(points.getPoints()).hasSize(numberOfPlayers);
    }

    @DisplayName("위치를 갖는 한 개의 라인을 생성한다")
    @Test
    void createLine_hasStrategy_success() {
        // given
        int numberOfPlayers = 2;

        // when
        Line points = Line.of(numberOfPlayers, () -> true);

        // then
        assertThat(points).isNotNull();
        assertThat(points.getPoints()).containsExactly(true, false);
    }


    @DisplayName("플레이어 수 만큼 위치를 생성하는데 성공한다")
    @Test
    void createPoint_countByPlayer_success() {
        // given
        int countByPlayers = 5;

        // when
        Line line = Line.of(countByPlayers);
        List<Boolean> points = line.getPoints();

        // then
        assertThat(points).hasSize(countByPlayers);
    }

    @DisplayName("전 위치에서 이동가능 한 경우, 위치는 이동이 불가능하다.")
    @Test
    void whenBeforePointTrue_Then_currentPoint_isFalse() {
        // when
        Line line = Line.of(5);
        List<Boolean> points = line.getPoints();
        boolean nextPoint = points.get(1);

        // then
        assertThat(nextPoint).isFalse();
    }

    @DisplayName("마지막 위치는 항상 이동이 불가능하다")
    @Test
    void lastPoint_isFalse_success() {
        // when
        Line line = Line.of(5);
        List<Boolean> points = line.getPoints();
        boolean lastPoint = points.get(points.size() - 1);

        // then
        assertThat(lastPoint).isFalse();
    }
}
