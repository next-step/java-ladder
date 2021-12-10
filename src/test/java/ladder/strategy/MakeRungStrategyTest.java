package ladder.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MakeRungStrategyTest {

    @DisplayName("isRungSet, randomBoolean 조건에 따른 결과 확인")
    @ParameterizedTest
    @MethodSource(value = "provideCondition")
    void of(boolean isRungSet, boolean randomBoolean, boolean expected) {
        MakeRungStrategy strategy = MakeRungStrategy.of(isRungSet, randomBoolean);
        assertThat(strategy.test()).isEqualTo(expected);
    }

    private static Stream<Arguments> provideCondition() {
        return Stream.of(
                Arguments.of(true, true, false),
                Arguments.of(true, false, false),
                Arguments.of(false, true, true),
                Arguments.of(false, false, false)
        );
    }

}
