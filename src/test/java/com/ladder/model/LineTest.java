package com.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.ladder.model.Point.POINT_LEFT;
import static com.ladder.model.Point.POINT_RIGHT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

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
        assertThat(points.getPoints()).containsExactly(POINT_RIGHT, POINT_LEFT);
    }


    @DisplayName("플레이어 수 만큼 위치를 생성하는데 성공한다")
    @Test
    void createPoint_countByPlayer_success() {
        // given
        int countByPlayers = 5;

        // when
        Line line = Line.of(countByPlayers);
        List<Point> points = line.getPoints();

        // then
        assertThat(points).hasSize(countByPlayers);
    }

    @DisplayName("플레이어의 위치를 이동하는데 성공한다")
    @Test
    void movePoint_positionOfPlayer_success() {
        // given
        Position currentPosition = Position.of(1);

        // when
        Line line = Line.of(Arrays.asList(POINT_LEFT, POINT_RIGHT, POINT_LEFT));
        Position movingResult = line.move(currentPosition);

        // then
        assertThat(movingResult).isEqualTo(currentPosition.moveForward());
    }
}