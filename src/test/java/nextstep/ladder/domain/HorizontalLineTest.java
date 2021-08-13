package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import nextstep.ladder.domain.common.Direction;
import nextstep.ladder.domain.common.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("가로줄")
class HorizontalLineTest {

    @DisplayName("생성 - 참여자 수")
    @ParameterizedTest
    @CsvSource(value = {
        "5"
    })
    public void create_withPlayerCount(final int playerCount) {
        // given

        // when
        final HorizontalLine horizontalLine = HorizontalLine.of(playerCount);

        // then
        assertThat(horizontalLine).isNotNull();
        assertThat(horizontalLine.size()).isEqualTo(playerCount);
    }

    public static Stream<Arguments> moveLine() {
        final List<Point> points = Arrays.asList(
            Point.of(0, Direction.of(false, true)),
            Point.of(1, Direction.of(true, false)),
            Point.of(2, Direction.of(false, false)),
            Point.of(3, Direction.of(false, true)),
            Point.of(4, Direction.of(true, false))
        );

        final HorizontalLine line = HorizontalLine.of(points);

        return Stream.of(
            Arguments.of(line, 0, 1),
            Arguments.of(line, 1, 0),
            Arguments.of(line, 2, 2),
            Arguments.of(line, 3, 4),
            Arguments.of(line, 4, 3)
        );
    }

    @DisplayName("[성공] 다음 가로줄로 이동시 인덱스")
    @ParameterizedTest
    @MethodSource("moveLine")
    public void next(final HorizontalLine horizontalLine, final int current, final int expected) {
        // given

        // when
        final int next = horizontalLine.move(current);

        // then
        assertThat(next).isEqualTo(expected);
    }
}
