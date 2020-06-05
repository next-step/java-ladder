package ladder.step4.domain;

import ladder.step4.domain.strategy.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DirectionStrategyTest {

    private static final DirectionStrategy bodyStrategy = BodyDirectionStrategy.getInstance();
    private static final DirectionStrategy tailStrategy = TailDirectionStrategy.getInstance();

    @DisplayName("사다리에 줄이 생기지 말아야할 경우에 대한 테스트")
    @ParameterizedTest
    @MethodSource("provideDirection")
    void 사다리_줄_생성_테스트(Direction prev) {
        assertEquals(false, bodyStrategy.create(prev) == prev);
    }

    private static Stream<Arguments> provideDirection () {
        return Stream.of(
          Arguments.of(Direction.LEFT),
          Arguments.of(Direction.RIGHT)
        );
    }

    @DisplayName("마지막 줄에 대한 생성 테스트")
    @ParameterizedTest
    @MethodSource("provideDirectionAndTailDirection")
    void 마지막_줄_생성_테스트(Direction prev, Direction expected) {
        assertEquals(expected, tailStrategy.create(prev));
    }

    private static Stream<Arguments> provideDirectionAndTailDirection () {
        return Stream.of(
            Arguments.of(Direction.LEFT, Direction.EMPTY),
            Arguments.of(Direction.RIGHT, Direction.LEFT),
            Arguments.of(Direction.EMPTY, Direction.EMPTY)
        );
    }

    @DisplayName("새로운 전략 생성에 대한 테스트")
    @ParameterizedTest
    @MethodSource("provideLadderStrategy")
    void 사다리_줄_전략_테스트(DirectionStrategy strategy, Direction direction, boolean expected) {
        assertEquals(expected, strategy.create(direction));
    }

    private static Stream<Arguments> provideLadderStrategy() {
        DirectionStrategy rightDirectionStrategy = prev -> Direction.RIGHT;
        DirectionStrategy leftDirectionStrategy = prev -> Direction.LEFT;
        DirectionStrategy emptyDirectionStrategy = prev -> Direction.EMPTY;
        DirectionStrategy toggleStrategy = prev -> prev == Direction.LEFT ? Direction.RIGHT : Direction.LEFT;
        return Stream.of(
            Arguments.of(rightDirectionStrategy, Direction.RIGHT, Direction.RIGHT),
            Arguments.of(leftDirectionStrategy, Direction.LEFT, Direction.LEFT),
            Arguments.of(emptyDirectionStrategy, Direction.EMPTY, Direction.EMPTY),
            Arguments.of(toggleStrategy, Direction.RIGHT, Direction.LEFT),
            Arguments.of(toggleStrategy, Direction.LEFT, Direction.RIGHT),
            Arguments.of(toggleStrategy, Direction.EMPTY, Direction.LEFT)
        );
    }
}
