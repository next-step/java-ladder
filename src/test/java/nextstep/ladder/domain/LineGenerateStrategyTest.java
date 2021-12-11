package nextstep.ladder.domain;

import java.util.stream.Stream;

import nextstep.ladder.domain.line.LineGenerateStrategy;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LineGenerateStrategyTest {
    static Stream<Arguments> parseGenerate() {
        return Stream.of(
                Arguments.of(LineGenerateStrategy.NO_LINE_STRATEGY)
        );
    }

    @ParameterizedTest(name = "generated line must not be in succession: {arguments}")
    @MethodSource("parseGenerate")
    public void generateNotInSuccession(LineGenerateStrategy strategy) {
        final int numberOfPlayer = 5;
        assertThat(strategy.generate(numberOfPlayer)
                .stream()
                .reduce(false, Boolean::logicalOr, Boolean::logicalAnd)).isFalse();
    }

    static Stream<Arguments> parseGenerateFailed() {
        return Stream.of(
                Arguments.of(TestLineStrategy.INVALID_ALL_LINE_STRATEGY),
                Arguments.of(TestLineStrategy.INVALID_TRUE_IN_SUCCESSION_STRATEGY)
        );
    }

    @ParameterizedTest(name = "generated line failed if be in succession: {arguments}")
    @MethodSource("parseGenerateFailed")
    public void generateFailedInSuccession(LineGenerateStrategy strategy) {
        final int numberOfPlayer = 2;
        assertThat(strategy.generate(numberOfPlayer)
                .stream()
                .reduce(false, Boolean::logicalOr, Boolean::logicalAnd)).isTrue();
    }
}
