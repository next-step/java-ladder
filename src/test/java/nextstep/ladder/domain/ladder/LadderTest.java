package nextstep.ladder.domain.ladder;

import nextstep.ladder.exception.NullArgumentException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static nextstep.ladder.domain.Fixture.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("사다리를 표현하는 클래스 테스트")
class LadderTest {

    @DisplayName("사다리는 사다리 초기화 정보를 가지고 초기화한다")
    @Test
    void init() {
        assertThat(Ladder.init(LADDER_INIT_INFO_2_X_2_TEMP)).isInstanceOf(Ladder.class);
    }

    @DisplayName("사다리 초기화 정보가 null 일 경우 예외를 발생시킨다")
    @Test
    void initException() {
        assertThatThrownBy(() -> Ladder.init(null)).isInstanceOf(NullArgumentException.class);
    }

    @DisplayName("각 행의 사다리 다리를 정보를 반환한다")
    @Test
    void getSteps() {
        Ladder ladder = Ladder.init(LADDER_INIT_INFO_2_X_2_TEMP);

        ladder.getSteps()
                .forEach(rowDto -> assertThat(rowDto.getSteps()).isEqualTo(Arrays.asList(true, false)));
    }

    @DisplayName("사다리 타기 결과는 LadderRideResult 를 반환한다")
    @Test
    void rideLadder() {
        Ladder ladder = Ladder.init(LADDER_INIT_INFO_2_X_2_TEMP);

        assertThat(ladder.ride()).isInstanceOf(LadderRideResult.class);
    }

    @DisplayName("사다리 타기 결과는 확인")
    @MethodSource
    @ParameterizedTest
    void checkRideLadderResult(LadderPosition startPosition, LadderPosition expectedPosition) {
        Ladder ladder = Ladder.init(LADDER_INIT_INFO_5_X_5_TEMP);

        LadderRideResult ladderRideResult = ladder.ride();
        assertThat(ladderRideResult.endPositionOf(startPosition)).isEqualTo(expectedPosition);
    }

    private static Stream<Arguments> checkRideLadderResult() {
        return Stream.of(
                Arguments.of(LadderPosition.from(0), LadderPosition.from(1)),
                Arguments.of(LadderPosition.from(1), LadderPosition.from(0)),
                Arguments.of(LadderPosition.from(2), LadderPosition.from(3)),
                Arguments.of(LadderPosition.from(3), LadderPosition.from(2)),
                Arguments.of(LadderPosition.from(4), LadderPosition.from(4))
        );
    }
}
