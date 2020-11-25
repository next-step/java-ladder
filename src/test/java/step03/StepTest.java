package step03;

import exception.InvalidPointsOfStepException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step02.domain.Step;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StepTest {

    private static Stream<Arguments> provideCountOfParticipantsResult() {
        return Stream.of(
                Arguments.of(2, true),
                Arguments.of(3, false)
        );
    }

    @DisplayName("인자 CountOfParticipants, 생성자")
    @ParameterizedTest
    @MethodSource("provideCountOfParticipantsResult")
    void test_constructor_of_CountOfParticipants(Integer countOfParticipants, boolean pointStrategy) {
        assertThat(Step.of(countOfParticipants, () -> pointStrategy))
                .isEqualTo(Step.of(countOfParticipants, () -> pointStrategy));
    }

    private static Stream<List<Boolean>> provideListOfBooleanResult() {
        return Stream.of(
                Arrays.asList(true, false, true, false),
                Arrays.asList(true, false, false, true)
        );
    }

    @DisplayName("인자 ListOfBoolean 생성자")
    @ParameterizedTest
    @MethodSource("provideListOfBooleanResult")
    void test_constructor_of_ListOfBoolean(List<Boolean> points) {
        assertThat(Step.of(points))
                .isEqualTo(Step.of(points));
    }

    private static Stream<List<Boolean>> provideInvalidPointsResult() {
        return Stream.of(
                Arrays.asList(true, true, false),
                Arrays.asList(false, true, true)
        );
    }

    @DisplayName("points 가 유효하지 않으면 에러 던짐")
    @ParameterizedTest
    @MethodSource("provideInvalidPointsResult")
    void test_validate(List<Boolean> points) {
        assertThatExceptionOfType(InvalidPointsOfStepException.class)
                .isThrownBy(() -> Step.of(points));
    }

    @DisplayName("출력을 위한 기능")
    @ParameterizedTest
    @MethodSource("provideListOfBooleanResult")
    void test_getStep(List<Boolean> points) {
        assertThat(Step.of(points).getPoints())
                .isEqualTo(points);
    }
}
