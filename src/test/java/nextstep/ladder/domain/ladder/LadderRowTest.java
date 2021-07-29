package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.init.LadderInitInfo;
import nextstep.ladder.domain.init.LadderSize;
import nextstep.ladder.domain.strategy.StepGenerateStrategy;
import nextstep.ladder.exception.NullArgumentException;
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
class LadderRowTest {

    @DisplayName("사다리 한 행은 사다리 초기화 정보 클래스를 가지고 초기화 한다")
    @Test
    void init() {
        assertThat(LadderRow.init(LADDER_INIT_INFO_2_X_2)).isInstanceOf(LadderRow.class);
    }

    @DisplayName("사다리 초기화 정보 클래스가 null 일 경우 예외를 발생 시킨다")
    @Test
    void initException() {
        assertThatThrownBy(() -> LadderRow.init(null)).isInstanceOf(NullArgumentException.class);
    }

    @DisplayName("사다리 한 행의 발판 정보를 반환한다")
    @MethodSource
    @ParameterizedTest
    void toSteps(LadderSize ladderSize, StepGenerateStrategy stepGenerateStrategy, List<Boolean> expectedSteps) {
        LadderInitInfo ladderInitInfo = LadderInitInfo.init(ladderSize, stepGenerateStrategy);
        LadderRow ladderRow = LadderRow.init(ladderInitInfo);

        assertThat(ladderRow.toSteps()).isEqualTo(expectedSteps);
    }

    private static Stream<Arguments> toSteps() {
        return Stream.of(
                Arguments.of(LADDER_SIZE_5_X_5, ALWAYS_GENERATE_STRATEGY, Arrays.asList(true, false, true, false, false)),
                Arguments.of(LADDER_SIZE_5_X_5, NEVER_GENERATE_STRATEGY, Arrays.asList(false, false, false, false, false))
        );
    }

    @DisplayName("사다리 한 행에서 사다리 타기")
    @MethodSource
    @ParameterizedTest
    void ride(LadderPosition curPosition, LadderPosition expectedPosition) {
        LadderInitInfo ladderInitInfo = LadderInitInfo.init(LADDER_SIZE_5_X_5, ALWAYS_GENERATE_STRATEGY);
        LadderRow ladderRow = LadderRow.init(ladderInitInfo);

        assertThat(ladderRow.ride(curPosition)).isEqualTo(expectedPosition);
    }

    private static Stream<Arguments> ride() {
        return Stream.of(
                Arguments.of(LadderPosition.from(0), LadderPosition.from(1)),
                Arguments.of(LadderPosition.from(1), LadderPosition.from(0)),
                Arguments.of(LadderPosition.from(2), LadderPosition.from(3)),
                Arguments.of(LadderPosition.from(3), LadderPosition.from(2)),
                Arguments.of(LadderPosition.from(4), LadderPosition.from(4))
        );
    }
}
