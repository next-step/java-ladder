package ladder.step4.domain;

import ladder.step4.domain.strategy.*;
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
        DirectionStrategy toggleStrategy = ToggleDirectionStrategy.getInstance();
        DirectionStrategy rightStrategy = RightDirectionStrategy.getInstance();
        DirectionStrategy emptyStrategy = EmptyDirectionStrategy.getInstance();
        return Stream.of(
            Arguments.of(LadderLine.of(2, toggleStrategy), 1),
            Arguments.of(LadderLine.of(3, toggleStrategy), 2),
            Arguments.of(LadderLine.of(4, toggleStrategy), 2),
            Arguments.of(LadderLine.of(5, toggleStrategy), 3),
            Arguments.of(LadderLine.of(6, toggleStrategy), 3),
            Arguments.of(LadderLine.of(2, rightStrategy), 2),
            Arguments.of(LadderLine.of(3, rightStrategy), 3),
            Arguments.of(LadderLine.of(4, rightStrategy), 4),
            Arguments.of(LadderLine.of(5, rightStrategy), 5),
            Arguments.of(LadderLine.of(2, emptyStrategy), 0),
            Arguments.of(LadderLine.of(3, emptyStrategy), 0),
            Arguments.of(LadderLine.of(4, emptyStrategy), 0),
            Arguments.of(LadderLine.of(5, emptyStrategy), 0)
        );
    }

    @DisplayName("각 줄에서의 이동이 정확한지 확인")
    @ParameterizedTest
    @MethodSource("provideLadderLineAndIndex")
    void 라인_이동_테스트 (int moved, int expected) {
        assertEquals(expected, moved);
    }

    private static Stream<Arguments> provideLadderLineAndIndex () {
        LadderLine ladderLineToggle = LadderLine.of(4, ToggleDirectionStrategy.getInstance());
        LadderLine ladderLineRight = LadderLine.of(4, RightDirectionStrategy.getInstance());
        LadderLine ladderLineLeft = LadderLine.of(4, LeftDirectionStrategy.getInstance());
        LadderLine ladderLineEmpty = LadderLine.of(4, EmptyDirectionStrategy.getInstance());
        return Stream.of(
            Arguments.of(ladderLineToggle.move(0), 1),
            Arguments.of(ladderLineToggle.move(1), 0),
            Arguments.of(ladderLineToggle.move(2), 3),
            Arguments.of(ladderLineToggle.move(3), 2),
            Arguments.of(ladderLineRight.move(0), 1),
            Arguments.of(ladderLineRight.move(1), 2),
            Arguments.of(ladderLineRight.move(2), 3),
            Arguments.of(ladderLineRight.move(3), 4),
            Arguments.of(ladderLineLeft.move(0), 0),
            Arguments.of(ladderLineLeft.move(1), 0),
            Arguments.of(ladderLineLeft.move(2), 1),
            Arguments.of(ladderLineLeft.move(3), 2),
            Arguments.of(ladderLineEmpty.move(0), 0),
            Arguments.of(ladderLineEmpty.move(1), 1),
            Arguments.of(ladderLineEmpty.move(2), 2),
            Arguments.of(ladderLineEmpty.move(3), 3)
        );
    }
}
