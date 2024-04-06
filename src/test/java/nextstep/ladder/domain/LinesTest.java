package nextstep.ladder.domain;

import nextstep.ladder.data.MoveDirection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LinesTest {

    @DisplayName("게임의 결과를 받을 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"0,1", "1,0", "2,3", "3,2", "4,4"}, delimiter = ',')
    void getGameResult(int startPosition, int expected) {
        // given
        List<Point> points = List.of(
                LeftSidePoint.create(MoveDirection.RIGHT),
                MiddlePoint.create(MoveDirection.RIGHT, MoveDirection.LEFT),
                MiddlePoint.create(MoveDirection.LEFT, MoveDirection.RIGHT),
                MiddlePoint.create(MoveDirection.RIGHT, MoveDirection.LEFT),
                RightSidePoint.create(MoveDirection.LEFT, MoveDirection.STAY)
        );

        LineStrategy customStrategy = (count) -> Line.of(points);

        Lines lines = Lines.of(Floor.from(3), 5, customStrategy);

        // then
        assertThat(lines.getUserWinLocation(startPosition)).isEqualTo(expected);
    }

    @DisplayName("막대기(Pole)의 개수와 전략으로 받은 Pole의 개수는 항상 같다. 아니라면 IllegalArguemntException을 던진다.")
    @Test
    void throwIllegalArgumentExceptionOfPoleCount() {
        // given
        List<Point> points = List.of(
                LeftSidePoint.create(MoveDirection.RIGHT),
                MiddlePoint.create(MoveDirection.RIGHT, MoveDirection.LEFT),
                MiddlePoint.create(MoveDirection.LEFT, MoveDirection.RIGHT),
                MiddlePoint.create(MoveDirection.RIGHT, MoveDirection.LEFT),
                RightSidePoint.create(MoveDirection.LEFT, MoveDirection.STAY)
        );

        LineStrategy customStrategy = (count) -> Line.of(points);

        // then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Lines.of(Floor.from(3), 1, customStrategy));
    }
}
