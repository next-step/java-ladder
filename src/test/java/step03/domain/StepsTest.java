package step03.domain;

import exception.InvalidCountOfStepsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import step02.domain.Participants;
import step02.domain.StepGenerator;
import step02.domain.Steps;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StepsTest {
    StepGenerator stepGenerator;
    Participants participants;

    @BeforeEach
    void setup() {
        participants = Participants.of("pobi,honux,crong,jk");
        stepGenerator = StepGenerator.of(participants, () -> true);
    }

    @DisplayName("생성자")
    @Test
    void test_constructor_of() {
        assertThat(Steps.of(1, stepGenerator))
                .isEqualTo(Steps.of(1, stepGenerator));
    }

    private static Stream<Integer> provideInvalidCountOfStepsResult() {
        return Stream.of(-1, 0);
    }

    @DisplayName("Steps 가 1 이상이 아니면 예외 처리")
    @ParameterizedTest
    @MethodSource("provideInvalidCountOfStepsResult")
    void test_validate(Integer countOfSteps) {
        assertThatExceptionOfType(InvalidCountOfStepsException.class)
                .isThrownBy(() -> Steps.of(countOfSteps, stepGenerator));
    }

    @DisplayName("출력을 위한 기능")
    @Test
    void test_getSteps() {
        assertThat(Steps.of(2, stepGenerator).getSteps())
        .isEqualTo(Arrays.asList(
                Arrays.asList(true, false, true),
                Arrays.asList(true, false, true)));
    }


}
