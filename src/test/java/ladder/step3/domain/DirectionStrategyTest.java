package ladder.step3.domain;

import ladder.step3.domain.strategy.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DirectionStrategyTest {

    private static final LadderLineStrategy strategy = LadderLineStrategyImpl.getInstance();

    @DisplayName("사다리에 줄이 생기지 말아야할 경우에 대한 테스트")
    @Test
    void 사다리_줄_생성_테스트() {
        assertEquals(false, strategy.createLine(true));
    }

    @DisplayName("새로운 전략 생성에 대한 테스트")
    @ParameterizedTest
    @MethodSource("provideLadderStrategy")
    void 사다리_줄_전략_테스트(LadderLineStrategy strategy, boolean prev, boolean expected) {
        assertEquals(expected, strategy.createLine(prev));
    }

    private static Stream<Arguments> provideLadderStrategy() {
        LadderLineStrategy alwaysTrueStrategy = prev -> true;
        LadderLineStrategy toggleStrategy = prev -> !prev;
        return Stream.of(
            Arguments.of(alwaysTrueStrategy, true, true),
            Arguments.of(alwaysTrueStrategy, false, true),
            Arguments.of(toggleStrategy, true, false),
            Arguments.of(toggleStrategy, false, true)
        );
    }
}
