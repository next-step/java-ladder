package ladder.step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderPointTest {
    @DisplayName("사다리 이동에 대한 테스트")
    @ParameterizedTest
    @MethodSource("provideLadderPointAndResultIndex")
    void 사다리_이동_테스트 (LadderPoint ladderPoint, int expected) {
        assertEquals(ladderPoint.move(), expected);
    }

    private static Stream<Arguments> provideLadderPointAndResultIndex () {
        return Stream.of(
            Arguments.of(LadderPoint.of(0, Direction.RIGHT), 1),
            Arguments.of(LadderPoint.of(0, Direction.EMPTY), 0),
            Arguments.of(LadderPoint.of(1, Direction.LEFT), 0)
        );
    }
}
