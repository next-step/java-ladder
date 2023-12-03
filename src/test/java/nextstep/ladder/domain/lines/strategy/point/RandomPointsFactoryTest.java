package nextstep.ladder.domain.lines.strategy.point;

import static nextstep.ladder.domain.Point.LINE;
import static nextstep.ladder.domain.Point.NOTHING;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.Stream;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class RandomPointsFactoryTest {

    @ParameterizedTest
    @DisplayName("첫번째 포인트들을 생성한다.")
    @CsvSource(value = {"LINE, LINE", "NOTHING, NOTHING"})
    void create_first_points(Point point, Point expected) {
        // given
        RandomPointsFactory randomPointsFactory = new RandomPointsFactory(currentPoint -> point);

        // when
        List<Point> result = randomPointsFactory.createNextPoints(
                Line.createLineWithPointStatus(List.of(false, false, false, false)), 4);

        // then
        assertThat(result).isEqualTo(List.of(expected, expected, expected, expected));
    }

    @ParameterizedTest
    @DisplayName("이전 포인트들의 상태에 따라 새로운 포인트들을 생성한다.")
    @MethodSource("parametersProvider")
    void create_next_points(boolean pointStatus, List<Boolean> beforePointStatus, List<Point> expected) {
        // given
        RandomPointsFactory randomPointsFactory = new RandomPointsFactory(
                beforePoint -> beforePoint.createNonOverlappingPoint(pointStatus));

        // when
        List<Point> result = randomPointsFactory.createNextPoints(
                Line.createLineWithPointStatus(beforePointStatus), 4);

        // then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> parametersProvider() {
        return Stream.of(
                arguments(true, List.of(true, false, true, false), List.of(NOTHING, LINE, NOTHING, LINE)),
                arguments(false, List.of(false, false, false, true), List.of(NOTHING, NOTHING, NOTHING, NOTHING)),
                arguments(true, List.of(false, false, false, false), List.of(LINE, LINE, LINE, LINE))
        );
    }
}
