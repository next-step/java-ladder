package nextstep.ladder.domain.init;

import nextstep.ladder.domain.strategy.StepGenerateStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static nextstep.ladder.domain.Fixture.ALWAYS_GENERATE_STRATEGY;
import static nextstep.ladder.domain.Fixture.LADDER_SIZE_2_X_2;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("사다리 초기화 정보를 담은 클래스 테스트")
class LadderInitInfoTest {

    @DisplayName("사다리 초기화 정보는 사다리 크기와 발판 생성 전략을 가지고 생성한다")
    @Test
    void init() {
        assertThat(LadderInitInfo.init(LADDER_SIZE_2_X_2, ALWAYS_GENERATE_STRATEGY)).isInstanceOf(LadderInitInfo.class);
    }

    @DisplayName("사다리 초기화 정보 중 null 값이 있다면 예외를 발생 시킨다")
    @MethodSource
    @ParameterizedTest
    void initException(LadderSize ladderSize, StepGenerateStrategy stepGenerateStrategy) {
        assertThatThrownBy(() -> LadderInitInfo.init(ladderSize, stepGenerateStrategy)).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> initException() {
        return Stream.of(
                Arguments.of(null, ALWAYS_GENERATE_STRATEGY),
                Arguments.of(LADDER_SIZE_2_X_2, null),
                Arguments.of(null, null)
        );
    }
}
