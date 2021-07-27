package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.strategy.StepGenerateStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static nextstep.ladder.domain.Fixture.*;
import static nextstep.ladder.domain.ladder.Step.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("사다리 발판에 대한 테스트")
class StepTest {

    @DisplayName("발판 생성은 전략에 따라 달라진다")
    @MethodSource
    @ParameterizedTest
    void init(StepGenerateStrategy stepGenerateStrategy, Step expectedStep) {
        assertThat(Step.init(stepGenerateStrategy)).isEqualTo(expectedStep);
    }

    private static Stream<Arguments> init() {
        return Stream.of(
                Arguments.of(ALWAYS_GENERATE_STRATEGY, RIGHT),
                Arguments.of(NEVER_GENERATE_STRATEGY, NONE)
        );
    }

    @DisplayName("중간 발판 생성은 이전 컬럼의 발판과 전략에 따라 달라진다")
    @MethodSource
    @ParameterizedTest
    void initMiddle(Step prevStep, StepGenerateStrategy stepGenerateStrategy, Step expectedStep) {
        assertThat(prevStep.initNext(stepGenerateStrategy)).isEqualTo(expectedStep);
    }

    private static Stream<Arguments> initMiddle() {
        return Stream.of(
                Arguments.of(RIGHT, ALWAYS_GENERATE_STRATEGY, LEFT),
                Arguments.of(RIGHT, NEVER_GENERATE_STRATEGY, LEFT),
                Arguments.of(LEFT, ALWAYS_GENERATE_STRATEGY, RIGHT),
                Arguments.of(LEFT, NEVER_GENERATE_STRATEGY, NONE),
                Arguments.of(NONE, ALWAYS_GENERATE_STRATEGY, RIGHT),
                Arguments.of(NONE, NEVER_GENERATE_STRATEGY, NONE)
        );
    }

    @DisplayName("마지막 발판 생성은 이전 컬럼의 발판에 따라 달라진다")
    @MethodSource
    @ParameterizedTest
    void initLast(Step prevStep, Step expectedStep) {
        assertThat(prevStep.initLast()).isEqualTo(expectedStep);
    }

    private static Stream<Arguments> initLast() {
        return Stream.of(
                Arguments.of(RIGHT, LEFT),
                Arguments.of(LEFT, NONE),
                Arguments.of(NONE, NONE)
        );
    }

    @DisplayName("첫번째 발판 생성에서 발판 생성 전략이 null 일 경우 예외를 반환한다")
    @Test
    void initException() {
        assertThatThrownBy(() -> Step.init(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중간 발판 생성에서 발판 생성 전략이 null 일 경우 예외를 반환한다")
    @Test
    void initMiddleException() {
        assertThatThrownBy(() -> LEFT_STEP_COLUMN.initNext(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("발판이 오른쪽인지 아닌지 판별한다")
    @MethodSource
    @ParameterizedTest
    void isRight(Step step, boolean expectedValue) {
        assertThat(step.isRight()).isEqualTo(expectedValue);
    }

    private static Stream<Arguments> isRight() {
        return Stream.of(
                Arguments.of(RIGHT, true),
                Arguments.of(LEFT, false),
                Arguments.of(NONE, false)
        );
    }

}
