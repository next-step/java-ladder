package ladder.domain;

import ladder.domain.ladder.Direction;
import ladder.domain.ladder.LadderLine;
import ladder.domain.ladder.Lines;
import ladder.domain.ladder.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LinesTest {

    static Stream<Arguments> sizeThreeArgs() {
        return Stream.of(
                Arguments.of(0, 1),
                Arguments.of(1, 0),
                Arguments.of(2, 2)
        );
    }

    static Stream<Arguments> sizeFourArgs() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(1, 1),
                Arguments.of(2, 2),
                Arguments.of(3, 3)
        );
    }

    @DisplayName("3개 사다리 경우 결과 도출 메소드 반환값 확인")
    @ParameterizedTest
    @MethodSource("sizeThreeArgs")
    void testIfGetValidLadderResultWithSizeThree(int participantOrder, int resultOrder) {
        LadderLine line1 = new LadderLine(new Point(0, Direction.of(false, true)), new Point(1, Direction.of(true, false)), new Point(2, Direction.of(false, false)));
        LadderLine line2 = new LadderLine(new Point(0, Direction.of(false, false)), new Point(1, Direction.of(false, true)), new Point(2, Direction.of(true, false)));
        LadderLine line3 = new LadderLine(new Point(0, Direction.of(false, false)), new Point(1, Direction.of(false, true)), new Point(2, Direction.of(true, false)));
        Lines lines = new Lines(line1, line2, line3);

        assertThat(lines.getEachResult(participantOrder)).isEqualTo(resultOrder);
    }

    @DisplayName("4개 사다리 경우 결과 도출 메소드 반환값 확인")
    @ParameterizedTest
    @MethodSource("sizeFourArgs")
    void testIfGetValidLadderResultWithSizeFour(int participantOrder, int resultOrder) {
        LadderLine line1 = new LadderLine(new Point(0, Direction.of(false, true)), new Point(1, Direction.of(true, false)), new Point(2, Direction.of(false, true)), new Point(3, Direction.of(true, false)));
        LadderLine line2 = new LadderLine(new Point(0, Direction.of(false, false)), new Point(1, Direction.of(false, true)), new Point(2, Direction.of(true, false)), new Point(3, Direction.of(false, false)));
        LadderLine line3 = new LadderLine(new Point(0, Direction.of(false, false)), new Point(1, Direction.of(false, true)), new Point(2, Direction.of(true, false)), new Point(3, Direction.of(false, false)));
        LadderLine line4 = new LadderLine(new Point(0, Direction.of(false, true)), new Point(1, Direction.of(true, false)), new Point(2, Direction.of(false, true)), new Point(3, Direction.of(true, false)));
        Lines lines = new Lines(line1, line2, line3, line4);

        assertThat(lines.getEachResult(participantOrder)).isEqualTo(resultOrder);
    }

}
