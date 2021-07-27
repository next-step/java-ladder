package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.strategy.StepGenerateStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static nextstep.ladder.domain.Fixture.ALWAYS_GENERATE_STRATEGY;
import static nextstep.ladder.domain.Fixture.NEVER_GENERATE_STRATEGY;
import static nextstep.ladder.domain.ladder.Step.*;
import static org.assertj.core.api.Assertions.assertThat;

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

}
