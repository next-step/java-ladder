package nextstep.ladder.domain;

import java.util.stream.Stream;

import nextstep.ladder.domain.line.LineGenerateStrategy;
import nextstep.ladder.domain.line.RandomLineStrategy;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static nextstep.ladder.domain.PlayerCountTest.pc;
import static org.assertj.core.api.Assertions.assertThat;

public class LineGenerateStrategyTest {
    static Stream<Arguments> parseGenerate() {
        return Stream.of(
                Arguments.of(TestLineStrategy.NO_LINE_STRATEGY),
                Arguments.of(TestLineStrategy.VALID_STRATEGY),
                Arguments.of(new RandomLineStrategy())
        );
    }

    @ParameterizedTest(name = "generated line must not be in succession: {arguments}")
    @MethodSource("parseGenerate")
    public void generateNotInSuccession(LineGenerateStrategy strategy) {
        final PlayerCount playerCount = pc(5);
        System.out.println(strategy.generate(playerCount));
        assertThat(strategy.generate(playerCount).size()).isEqualTo(playerCount.toInt());
        assertThat(strategy.generate(playerCount)
                .stream()
                .parallel()
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
        final PlayerCount playerCount = pc(5);
        assertThat(strategy.generate(playerCount)
                .stream()
                .reduce(false, Boolean::logicalOr, Boolean::logicalAnd)).isTrue();
    }
}
