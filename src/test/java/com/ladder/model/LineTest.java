package com.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static com.ladder.model.Direction.LEFT;
import static com.ladder.model.Direction.RIGHT;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
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
        Line points = Line.ofWithStrategy(numberOfPlayers, () -> true);

        // then
        assertThat(points).isNotNull();
        assertThat(points.getPoints())
                .containsExactly(
                        ofPoint(0, RIGHT),
                        ofPoint(1, LEFT));
    }

    public static Point ofPoint(int indexOfLadder, Direction direction) {
        return Point.of(indexOfLadder, direction);
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
        Line line = ofLine(LEFT, Direction.RIGHT, LEFT);
        Position movingResult = line.move(currentPosition);

        // then
        assertThat(movingResult).isEqualTo(currentPosition.moveForward());
    }

    static Line ofLine(Direction... directions) {
        return IntStream.range(0, directions.length)
                .mapToObj(num -> Point.of(num, directions[num]))
                .collect(collectingAndThen(toList(), Line::ofPoints));
    }
}