package nextstep.ladder.domain;

import nextstep.ladder.data.MoveDirection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @DisplayName("사다리 정보를 반환한다.")
    @Test
    void getLadderInfo() {
        // given
        List<String> users = List.of("yang", "gang", "eee");

        // when
        Ladder ladder = Ladder.of(7, users.size(), new RandomLineStrategy());
        List<Line> ladderInfo = ladder.getLadderInfo();

        // then
        assertThat(ladderInfo).hasSize(7);
    }

    @DisplayName("최종 위치를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"0,1", "1,0", "2,3", "3,2", "4,4"}, delimiter = ',')
    void getDestinationPosition(int departPosition, int expected) {
        // given
        List<Point> points = List.of(
                LeftSidePoint.create(MoveDirection.RIGHT),
                MiddlePoint.create(MoveDirection.RIGHT, MoveDirection.LEFT),
                MiddlePoint.create(MoveDirection.LEFT, MoveDirection.RIGHT),
                MiddlePoint.create(MoveDirection.RIGHT, MoveDirection.LEFT),
                RightSidePoint.create(MoveDirection.LEFT, MoveDirection.STAY)
        );

        LineStrategy customStrategy = (count) -> Line.of(points);

        // when
        Ladder ladder = Ladder.of(1, 5, customStrategy);

        // then
        assertThat(ladder.destinationPosition(departPosition)).isEqualTo(expected);
    }
}
