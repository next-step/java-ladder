package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


class LineTest {

    private static Stream<Arguments> makePatterns() {
        return Stream.of(
                Arguments.of((ConnectionMode) () -> false, 1),

                // false, true, false, true ....
                Arguments.of(new SampleShufflePattern(), 2),

                // PointStatus 의 방어로직에 의해 연속되어 생성되지 않는다.
                // true, false, true, false...
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

}
