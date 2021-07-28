package nextstep.ladder.domain.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static nextstep.ladder.domain.Fixture.ALWAYS_GENERATE_STRATEGY;
import static nextstep.ladder.domain.Fixture.NEVER_GENERATE_STRATEGY;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("발판을 생성여부를 판단하는 전략 테스트")
class StepGenerateStrategyTest {

    @DisplayName("생성 가능여부를 True / False 로 반환한다")
    @MethodSource
    @ParameterizedTest
    void isGenerable(StepGenerateStrategy stepGenerateStrategy, boolean expectedValue) {
        assertThat(stepGenerateStrategy.isGenerable()).isEqualTo(expectedValue);
    }

    private static Stream<Arguments> isGenerable() {
        return Stream.of(
                Arguments.of(ALWAYS_GENERATE_STRATEGY, true),
                Arguments.of(NEVER_GENERATE_STRATEGY, false)
        );
    }
}
