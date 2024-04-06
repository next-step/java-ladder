package nextstep.ladder.domain;

import nextstep.ladder.data.MoveDirection;
import nextstep.ladder.data.StepType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;


class LineTest {

    @DisplayName("첫 번째 Point는 항상 LeftSidePoint여야 한다.")
    @Test
    void leftAlwaysLeftSidePoint() {
        // given
        List<Point> points = List.of(
                MiddlePoint.create(MoveDirection.STAY, MoveDirection.STAY),
                RightSidePoint.create(MoveDirection.STAY, MoveDirection.STAY)
        );

        // then
        assertThatThrownBy(() -> Line.of(points))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("마지막 Point는 항상 RightSidePoint여야 한다.")
    @Test
    void rightAlwaysRightSidePoint() {
        // given
        List<Point> points = List.of(
                LeftSidePoint.create(MoveDirection.STAY),
                MiddlePoint.create(MoveDirection.STAY, MoveDirection.STAY)
        );

        // then
        assertThatThrownBy(() -> Line.of(points))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시작 전 위치를 주면, 현재 Line에 대한 이동 시 결과를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"0,0", "1,2", "2,1"}, delimiter = ',')
    void getDestinationPointFromDepartPoint(int departPosition, int expected) {
        // given
        List<Point> points = List.of(
                LeftSidePoint.create(MoveDirection.STAY),
                MiddlePoint.create(MoveDirection.STAY, MoveDirection.RIGHT),
                RightSidePoint.create(MoveDirection.RIGHT, MoveDirection.LEFT)
        );

        // when
        Line line = Line.of(points);

        // then
        assertThat(line.getDestinationFrom(departPosition)).isEqualTo(expected);
    }
}
