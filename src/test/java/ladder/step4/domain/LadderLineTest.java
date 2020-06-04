package ladder.step4.domain;

import ladder.step4.domain.strategy.LadderLineStrategy;
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
            ladderLine.stream().filter(v -> v).count()
        );
    }

    private static Stream<Arguments> provideLadderAndStrategy() {
        LadderLineStrategy toggleStrategy = prev -> !prev;
        LadderLineStrategy alwaysCreateStrategy = prev -> true;
        LadderLineStrategy alwaysDontCreateStrategy = prev -> false;
        return Stream.of(
            Arguments.of(LadderLine.of(2, toggleStrategy), 1),
            Arguments.of(LadderLine.of(3, toggleStrategy), 2),
            Arguments.of(LadderLine.of(4, toggleStrategy), 2),
            Arguments.of(LadderLine.of(5, toggleStrategy), 3),
            Arguments.of(LadderLine.of(2, alwaysCreateStrategy), 2),
            Arguments.of(LadderLine.of(3, alwaysCreateStrategy), 3),
            Arguments.of(LadderLine.of(4, alwaysCreateStrategy), 4),
            Arguments.of(LadderLine.of(5, alwaysCreateStrategy), 5),
            Arguments.of(LadderLine.of(2, alwaysDontCreateStrategy), 0),
            Arguments.of(LadderLine.of(3, alwaysDontCreateStrategy), 0),
            Arguments.of(LadderLine.of(4, alwaysDontCreateStrategy), 0),
            Arguments.of(LadderLine.of(5, alwaysDontCreateStrategy), 0)
        );
    }

}
