package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LinesTest {

    static Stream<Arguments> sizeThreeArgs() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(1, 1),
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

//    @DisplayName("3개 사다리 경우 결과 도출 메소드 반환값 확인")
//    @ParameterizedTest
//    @MethodSource("sizeThreeArgs")
//    void testIfGetValidLadderResultWithSizeThree(int participantOrder, int resultOrder) {
//        LadderLine line1 = new LadderLine(Point.first(true), , false);
//        LadderLine line2 = new LadderLine(false, true, false);
//        LadderLine line3 = new LadderLine(false, true, false);
//        Lines lines = new Lines(line1, line2, line3);
//
//        assertThat(lines.getEachResult(participantOrder)).isEqualTo(resultOrder);
//    }
//
//    @DisplayName("4개 사다리 경우 결과 도출 메소드 반환값 확인")
//    @ParameterizedTest
//    @MethodSource("sizeFourArgs")
//    void testIfGetValidLadderResultWithSizeFour(int participantOrder, int resultOrder) {
//        Line line1 = new Line(false, false, true, false);
//        Line line2 = new Line(false, true, false, true);
//        Line line3 = new Line(false, true, false, true);
//        Line line4 = new Line(false, false, true, false);
//        Lines lines = new Lines(line1, line2, line3, line4);
//
//        assertThat(lines.getEachResult(participantOrder)).isEqualTo(resultOrder);
//    }

}
