package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static nextstep.ladder.domain.ladder.Step.*;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사다리 발판에 대한 테스트")
class StepTest {

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

    @DisplayName("발판 방향에 따라 위치를 옮겨준다")
    @MethodSource
    @ParameterizedTest
    void move(Step step, LadderPosition ladderPosition, LadderPosition expectedPosition) {
        assertThat(step.move(ladderPosition)).isEqualTo(expectedPosition);
    }

    private static Stream<Arguments> move() {
        return Stream.of(
                Arguments.of(LEFT, LadderPosition.from(5), LadderPosition.from(4)),
                Arguments.of(RIGHT, LadderPosition.from(5), LadderPosition.from(6)),
                Arguments.of(NONE, LadderPosition.from(5), LadderPosition.from(5))
        );
    }

}
