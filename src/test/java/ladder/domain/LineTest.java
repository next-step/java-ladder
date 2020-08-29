package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    private static Stream<Arguments> makeLineCreateData() {
        return Stream.of(
                Arguments.of(Arrays.asList(Point.getFirst(true))
                        , 1, false),
                Arguments.of(Arrays.asList(Point.getFirst(true), Point.of(true, false), Point.getLast(false))
                        , 3, false),
                Arguments.of(Arrays.asList(Point.getFirst(true), Point.of(true, false)
                        , Point.of(false, false), Point.of(false, true), Point.getLast(true))
                        , 5, false),
                Arguments.of(Arrays.asList(Point.getFirst(true), Point.of(true, true)
                        , Point.of(true, false), Point.getLast(false))
                        , 4, true)
        );
    }

    @DisplayName("Line 생성 테스트")
    @ParameterizedTest
    @MethodSource("makeLineCreateData")
    void create(List<Point> points, int expectedParticipantNumber, boolean expectedResult) {
        Line line = Line.of(points);

        boolean actual = line.getPoints()
                .stream()
                .anyMatch(point -> point.isRight() && point.isLeft());

        // 참가자 수 만큼 생성되었는지 확인
        assertThat(line.getSize()).isEqualTo(expectedParticipantNumber);
        // 연속되지 않게 생성되었는지 확인
        assertThat(actual).isEqualTo(expectedResult);
    }

    @DisplayName("Line 특정 인덱스를 기준으로 다음 인덱스 계산 테스트")
    @ParameterizedTest
    @MethodSource("makeCalculateNextIndexData")
    void calculateNextIndex(List<Point> points, List<Integer> expectedResult) {
        Line line = Line.of(points);

        for (int index = 0; index < expectedResult.size(); index++) {
            int actualNextIndex = line.calculateNextIndex(index);
            int expectedNextIndex = expectedResult.get(index);

            assertThat(actualNextIndex).isEqualTo(expectedNextIndex);
        }
    }

    private static Stream<Arguments> makeCalculateNextIndexData() {
        return Stream.of(
                Arguments.of(Arrays.asList(Point.of(false, true), Point.of(true, false)
                        , Point.of(false, true), Point.of(true, false))
                        , Arrays.asList(1, 0, 3, 2)),
                Arguments.of(Arrays.asList(Point.of(false, false), Point.of(false, false))
                        , Arrays.asList(0, 1))
        );
    }
}
