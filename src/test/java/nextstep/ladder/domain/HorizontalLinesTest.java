package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.stream.Stream;
import nextstep.ladder.domain.common.Direction;
import nextstep.ladder.domain.common.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("가로줄들")
class HorizontalLinesTest {

    @DisplayName("[성공] 생성")
    @ParameterizedTest
    @CsvSource(value = {
        "10,5"
    })
    public void create(final int height, final int playerCount) {
        // given

        // when
        final HorizontalLines horizontalLines = HorizontalLines.of(height, playerCount);

        // then
        assertThat(horizontalLines.size()).isEqualTo(height);
        assertThat(horizontalLines.getValues().get(0).size()).isEqualTo(playerCount);
    }

    private static final HorizontalLines HORIZONTAL_LINES = new HorizontalLines(Arrays.asList(
        HorizontalLine.of(Arrays.asList(
            Point.of(0, Direction.of(false, true)),
            Point.of(1, Direction.of(true, false)),
            Point.of(2, Direction.of(false, false)),
            Point.of(3, Direction.of(false, true)),
            Point.of(4, Direction.of(true, false)))),
        HorizontalLine.of(Arrays.asList(
            Point.of(0, Direction.of(false, true)),
            Point.of(1, Direction.of(true, false)),
            Point.of(2, Direction.of(false, false)),
            Point.of(3, Direction.of(false, true)),
            Point.of(4, Direction.of(true, false))))
    ));

    public static Stream<Arguments> goal() {
        return Stream.of(
            Arguments.of(HORIZONTAL_LINES, 0, 0),
            Arguments.of(HORIZONTAL_LINES, 1, 1),
            Arguments.of(HORIZONTAL_LINES, 2, 2),
            Arguments.of(HORIZONTAL_LINES, 3, 3),
            Arguments.of(HORIZONTAL_LINES, 4, 4)
        );
    }

    @DisplayName("[성공] 도착지 index (최종 결과)")
    @ParameterizedTest
    @MethodSource("goal")
    public void goal(final HorizontalLines horizontalLines, final int start, final int expected) {
        // given

        // when
        final int goal = horizontalLines.move(start);

        // then
        assertThat(goal).isEqualTo(expected);
    }
}
