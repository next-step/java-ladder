package ladder.domain.ladder.strategy;

import ladder.domain.ladder.StairState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static ladder.fixture.StairGenerationStrategyFixture.FALSE_STRATEGY;
import static ladder.fixture.StairGenerationStrategyFixture.TRUE_STRATEGY;
import static org.assertj.core.api.Assertions.assertThat;

public class RandomStairGenerationStrategyTest {

    @DisplayName("true 또는 false 를 반환")
    @ParameterizedTest
    @MethodSource("generateCase")
    void generate(final StairGenerationStrategy strategy, final boolean expected) {
        assertThat(strategy.generate())
                .isEqualTo(expected);
    }

    private static Stream<Arguments> generateCase() {
        return Stream.of(
                Arguments.of(TRUE_STRATEGY, true),
                Arguments.of(FALSE_STRATEGY, false)
        );
    }

    @DisplayName("StairState 객체를 이용한 랜덤 전략 테스트")
    @ParameterizedTest
    @ValueSource(booleans = { true, false })
    void trueOrFalse(final boolean randomResult) {
        assertThat(StairState.ofFirstPillar(() -> randomResult).isRightLineExist())
                .isEqualTo(randomResult);
    }
}
