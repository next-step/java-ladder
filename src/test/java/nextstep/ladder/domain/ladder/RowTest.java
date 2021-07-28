package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.init.LadderInitInfo;
import nextstep.ladder.domain.init.LadderSize;
import nextstep.ladder.domain.strategy.StepGenerateStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static nextstep.ladder.domain.Fixture.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("사다리 한 행을 표현하는 로우 클래스에 대한 테스트")
class RowTest {

    @DisplayName("사다리 한 행은 사다리 초기화 정보 클래스를 가지고 초기화 한다")
    @Test
    void init() {
        assertThat(Row.init(LADDER_INIT_INFO_2_X_2)).isInstanceOf(Row.class);
    }

    @DisplayName("사다리 초기화 정보 클래스가 null 일 경우 예외를 발생 시킨다")
    @Test
    void initException() {
        assertThatThrownBy(() -> Row.init(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사다리 한 행의 발판 정보를 반환한다")
    @MethodSource
    @ParameterizedTest
    void toSteps(LadderSize ladderSize, StepGenerateStrategy stepGenerateStrategy, List<Boolean> expectedSteps) {
        LadderInitInfo ladderInitInfo = LadderInitInfo.init(ladderSize, stepGenerateStrategy);
        Row row = Row.init(ladderInitInfo);

        assertThat(row.toSteps()).isEqualTo(expectedSteps);
    }

    private static Stream<Arguments> toSteps() {
        return Stream.of(
                Arguments.of(LADDER_SIZE_5_X_5, ALWAYS_GENERATE_STRATEGY, Arrays.asList(true, false, true, false, false)),
                Arguments.of(LADDER_SIZE_5_X_5, NEVER_GENERATE_STRATEGY, Arrays.asList(false, false, false, false, false))
        );
    }
}
