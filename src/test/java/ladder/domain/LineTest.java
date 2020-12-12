package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


class LineTest {

    private static Stream<Arguments> makePatterns() {
        return Stream.of(
                Arguments.of((ConnectionMode) () -> false, 1),

                // false, true, false, true ...
                Arguments.of(new SampleShufflePattern(), 2),

                // PointStatus 의 방어로직에 의해 연속되어 생성되지 않는다.
                // true, false, true, false ...
                Arguments.of((ConnectionMode) () -> true, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("makePatterns")
    @DisplayName("배열에 따라 반환하는 값 테스트")
    void testResult(ConnectionMode mode, int expected) {
        Line line = Line.ofLineCounts(4, mode);

        int result = line.getNextIndex(1);

        assertThat(result).isEqualTo(expected);
    }


    private static Stream<Arguments> makeExpected() {
        return Stream.of(
                Arguments.of(0, 1),
                Arguments.of(1, 0),
                Arguments.of(2, 2),
                Arguments.of(3, 4),
                Arguments.of(4, 3)
        );
    }

    @MethodSource("makeExpected")
    @ParameterizedTest
    @DisplayName("배열 수동 생성에 따른 값 테스트")
    void testManualLine(int input, int expected) {
        Line sampleLine = Line.ofPoints(new ArrayList<>(Arrays.asList(
                Point.custom(0, PointStatus.custom(false, true)),
                Point.custom(1, PointStatus.custom(true, false)),
                Point.custom(2, PointStatus.custom(false, false)),
                Point.custom(3, PointStatus.custom(false, true)),
                Point.custom(4, PointStatus.custom(true, false))
        )));

        assertThat(sampleLine.getNextIndex(input)).isEqualTo(expected);
    }
}
