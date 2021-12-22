package nextstep.ladder.domain;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static nextstep.ladder.domain.TestLadderPointStrategy.ALL_LINE_STRATEGY;
import static nextstep.ladder.domain.TestLadderPointStrategy.INVALID_TRUE_IN_SUCCESSION_STRATEGY;
import static nextstep.ladder.domain.TestLadderPointStrategy.NO_LINE_STRATEGY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

public class LadderPointGenerateStrategyTest {
    static Stream<Arguments> parseGenerate() {
        return Stream.of(
                Arguments.of(NO_LINE_STRATEGY),
                Arguments.of(new TestLadderPointStrategy.ReverseLineStrategy()),
                Arguments.of(new RandomLadderPointStrategy())
        );
    }

    @ParameterizedTest(name = "generated line must not be in succession: {arguments}")
    @MethodSource("parseGenerate")
    public void generateNotInSuccession(LadderPointGenerateStrategy strategy) {
        final int repeatCount = 10;
        for (int i = 0; i < repeatCount; i++) {
            assertThat(strategy.generatePoint() && strategy.generatePoint()).isFalse();
        }
    }

    static Stream<Arguments> parseGenerateFailed() {
        return Stream.of(
                Arguments.of(ALL_LINE_STRATEGY),
                Arguments.of(INVALID_TRUE_IN_SUCCESSION_STRATEGY)
        );
    }

    @ParameterizedTest(name = "generated line failed if be in succession: {arguments}")
    @MethodSource("parseGenerateFailed")
    public void generateFailedInSuccession(LadderPointGenerateStrategy strategy) {
        Point point = Point.first(strategy.generatePoint());
        assertThatIllegalStateException()
                .isThrownBy(() -> point.next(strategy.generatePoint()));
    }
}
