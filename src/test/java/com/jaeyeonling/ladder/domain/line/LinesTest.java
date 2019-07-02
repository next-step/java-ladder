package com.jaeyeonling.ladder.domain.line;

import com.jaeyeonling.ladder.domain.Fixture;
import com.jaeyeonling.ladder.domain.point.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LinesTest {

    @DisplayName("라인들 생성을 성공한다.")
    @Test
    void should_create() {
        final List<Line> rawLines = List.of(Fixture.allStraightLine, Fixture.rightLeftLine);

        final Lines lines = Lines.of(rawLines);

        assertThat(lines).isNotNull();
    }

    @DisplayName("아래로만 내려가는 사다리를 타면 indexOfLadder는 고정되고 indexOfLine만 사다리 갯수만큼 증가한다.")
    @Test
    void should_move_always_straight_when_ride_STRAIGHT() {
        // given
        final int indexOfLadder = 0;
        final int indexOfLine = 0;
        final Point point = Point.of(indexOfLadder, indexOfLine);

        final List<Line> rawLines = Fixture.rawAllStraightLines;
        final Lines lines = Fixture.allStraightLines;

        // when
        final Point movedPoint = lines.ride(point);

        // then
        assertThat(movedPoint).isEqualTo(Point.of(indexOfLadder, indexOfLine + rawLines.size()));
    }

    @DisplayName("좌우로만 움직이는 사다리를 타면 indexOfLadder는 사다리 갯수를 2로 나눈 나머지 값이다. ")
    @Test
    void should_move_left_and_right_when_ride_LEFT_RIGHT() {
        // given
        final int indexOfLadder = 0;
        final int indexOfLine = 0;
        final Point point = Point.of(indexOfLadder, indexOfLine);

        final List<Line> rawLines = Fixture.rawAllRightLeftLines;
        final Lines lines = Fixture.allRightLeftLines;

        // when
        final Point movedPoint = lines.ride(point);
        final Point expect = Point.of(indexOfLadder + rawLines.size() % 2,
                indexOfLine + rawLines.size());

        // then
        assertThat(movedPoint).isEqualTo(expect);
    }
}
