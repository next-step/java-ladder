package ladder.step4.domain;

import ladder.step4.domain.strategy.DirectionStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderLineTest {

    @DisplayName("사다리가 정상적으로 잘 생성되는지 확인")
    @ParameterizedTest
    @MethodSource("provideLadderAndStrategy")
    void 사다리_생성_확인_테스트(LadderLine ladderLine, long expected) {
        assertEquals(
            expected,
            ladderLine.stream()
                      .filter(LadderPoint::isRight)
                      .count()
        );
    }

    private static Stream<Arguments> provideLadderAndStrategy() {
        DirectionStrategy toggleStrategy = Direction::toggle;
        DirectionStrategy rightStrategy = prev -> Direction.RIGHT;
        DirectionStrategy emptyStrategy = prev -> Direction.EMPTY;
        return Stream.of(
            Arguments.of(LadderLine.of(2, toggleStrategy), 1),
            Arguments.of(LadderLine.of(3, toggleStrategy), 1),
            Arguments.of(LadderLine.of(4, toggleStrategy), 2),
            Arguments.of(LadderLine.of(5, toggleStrategy), 2),
            Arguments.of(LadderLine.of(6, toggleStrategy), 3),
            Arguments.of(LadderLine.of(2, rightStrategy), 1),
            Arguments.of(LadderLine.of(3, rightStrategy), 2),
            Arguments.of(LadderLine.of(4, rightStrategy), 3),
            Arguments.of(LadderLine.of(5, rightStrategy), 4),
            Arguments.of(LadderLine.of(2, emptyStrategy), 0),
            Arguments.of(LadderLine.of(3, emptyStrategy), 0),
            Arguments.of(LadderLine.of(4, emptyStrategy), 0),
            Arguments.of(LadderLine.of(5, emptyStrategy), 0)
        );
    }

}
