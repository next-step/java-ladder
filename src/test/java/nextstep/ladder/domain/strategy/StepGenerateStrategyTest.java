package nextstep.ladder.domain.strategy;

import nextstep.ladder.domain.ladder.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static nextstep.ladder.domain.Fixture.*;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("발판을 생성을 담당하는 전략 테스트")
class StepGenerateStrategyTest {

    @DisplayName("첫번째 열의 발판 생성 전략 테스트")
    @MethodSource
    @ParameterizedTest
    void generateFirst(StepGenerateStrategy stepGenerateStrategy, Step expectedStep) {
        assertThat(stepGenerateStrategy.generateFirst()).isEqualTo(expectedStep);
    }

    private static Stream<Arguments> generateFirst() {
        return Stream.of(
                Arguments.of(ALWAYS_GENERATE_STRATEGY, Step.RIGHT),
                Arguments.of(NEVER_GENERATE_STRATEGY, Step.NONE)
        );
    }

    @DisplayName("중간 열의 발판 생성 전략 테스트")
    @MethodSource
    @ParameterizedTest
    void generateMiddle(Step prevStep, StepGenerateStrategy stepGenerateStrategy, Step expectedStep) {
        assertThat(stepGenerateStrategy.generateMiddle(prevStep)).isEqualTo(expectedStep);
    }

    private static Stream<Arguments> generateMiddle() {
        return Stream.of(
                Arguments.of(Step.RIGHT, ALWAYS_GENERATE_STRATEGY, Step.LEFT),
                Arguments.of(Step.LEFT, ALWAYS_GENERATE_STRATEGY, Step.RIGHT),
                Arguments.of(Step.NONE, ALWAYS_GENERATE_STRATEGY, Step.RIGHT),
                Arguments.of(Step.RIGHT, NEVER_GENERATE_STRATEGY, Step.LEFT),
                Arguments.of(Step.LEFT, NEVER_GENERATE_STRATEGY, Step.NONE),
                Arguments.of(Step.NONE, NEVER_GENERATE_STRATEGY, Step.NONE)
        );
    }

    @DisplayName("마지막 열의 발판 생성 전략 테스트")
    @MethodSource
    @ParameterizedTest
    void generateLast(Step prevStep, StepGenerateStrategy stepGenerateStrategy, Step expectedStep) {
        assertThat(stepGenerateStrategy.generateLast(prevStep)).isEqualTo(expectedStep);
    }

    private static Stream<Arguments> generateLast() {
        return Stream.of(
                Arguments.of(Step.RIGHT, ALWAYS_GENERATE_STRATEGY, Step.LEFT),
                Arguments.of(Step.LEFT, ALWAYS_GENERATE_STRATEGY, Step.NONE),
                Arguments.of(Step.NONE, ALWAYS_GENERATE_STRATEGY, Step.NONE),
                Arguments.of(Step.RIGHT, NEVER_GENERATE_STRATEGY, Step.LEFT),
                Arguments.of(Step.LEFT, NEVER_GENERATE_STRATEGY, Step.NONE),
                Arguments.of(Step.NONE, NEVER_GENERATE_STRATEGY, Step.NONE)
        );
    }
}
