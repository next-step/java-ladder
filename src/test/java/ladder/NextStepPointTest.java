package ladder;

import ladder.domain.nextstep.NextStepPoint;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class NextStepPointTest {
    @ParameterizedTest(name = "point_Next_RIGHT_Test")
    @MethodSource("point_Next_RIGHT_Provider")
    public void point_Next_RIGHT_Test(NextStepPoint point, NextStepPoint expected) {
        assertThat(NextStepPoint.next(point)).isNotEqualTo(expected);
    }

    static Stream<Arguments> point_Next_RIGHT_Provider() {
        return Stream.of(
                Arguments.of(NextStepPoint.RIGHT, NextStepPoint.DOWN),
                Arguments.of(NextStepPoint.RIGHT, NextStepPoint.RIGHT)
        );
    }

    @ParameterizedTest(name = "point_Next_Test")
    @MethodSource("point_Next_Provider")
    public void point_Next_Test(NextStepPoint point, NextStepPoint expected) {
        assertThat(NextStepPoint.next(point)).isNotEqualTo(expected);
    }

    static Stream<Arguments> point_Next_Provider() {
        return Stream.of(
                Arguments.of(NextStepPoint.LEFT, NextStepPoint.LEFT),
                Arguments.of(NextStepPoint.DOWN, NextStepPoint.LEFT)
        );
    }
}
