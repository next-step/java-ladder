package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    private static Stream<Arguments> makeLineCreateData() {
        return Stream.of(
                Arguments.of(Arrays.asList(Point.getFirst(true)), 1),
                Arguments.of(Arrays.asList(Point.getFirst(true), Point.of(true, false), Point.getLast(false)), 3),
                Arguments.of(Arrays.asList(Point.getFirst(true), Point.of(true, false), Point.of(false, false)
                        , Point.of(false, true), Point.getLast(true)), 5)
        );
    }

    @DisplayName("Line 생성 테스트")
    @ParameterizedTest
    @MethodSource("makeLineCreateData")
    void create(List<Point> points, int participantNumber) {
        Line line = Line.of(points);

        boolean actual = line.getPoints()
                .stream()
                .anyMatch(point -> point.isRight() && point.isLeft());

        // 참가자 수 만큼 생성되었는지 확인
        assertThat(line.getSize()).isEqualTo(participantNumber);
        // 연속되지 않게 생성되었는지 확인
        assertThat(actual).isFalse();
    }
}
