package ladder.step4.domain;

import ladder.step4.domain.strategy.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DirectionStrategyTest {

    private static final DirectionStrategy strategy = LadderDirectionStrategy.getInstance();

    @DisplayName("사다리에 줄이 생기지 말아야할 경우에 대한 테스트")
    @ParameterizedTest
    @MethodSource("provideDirection")
    void 사다리_줄_생성_테스트(Direction prev) {
        assertEquals(false, strategy.createBody(prev) == prev);
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
        assertEquals(expected, strategy.createTail(prev));
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
    void 사다리_줄_전략_테스트(DirectionStrategy strategy, Direction direction, Direction expected) {
        assertEquals(expected, strategy.createBody(direction));
        assertEquals(expected, strategy.createTail(direction));
    }

    private static Stream<Arguments> provideLadderStrategy() {
        DirectionStrategy rightDirectionStrategy = RightDirectionStrategy.getInstance();
        DirectionStrategy leftDirectionStrategy = LeftDirectionStrategy.getInstance();
        DirectionStrategy emptyDirectionStrategy = EmptyDirectionStrategy.getInstance();
        DirectionStrategy toggleStrategy = ToggleDirectionStrategy.getInstance();
        return Stream.of(
            Arguments.of(rightDirectionStrategy, Direction.RIGHT, Direction.RIGHT),
            Arguments.of(leftDirectionStrategy, Direction.LEFT, Direction.LEFT),
            Arguments.of(emptyDirectionStrategy, Direction.EMPTY, Direction.EMPTY),
            Arguments.of(toggleStrategy, Direction.RIGHT, Direction.LEFT),
            Arguments.of(toggleStrategy, Direction.LEFT, Direction.RIGHT)
        );
    }
}
