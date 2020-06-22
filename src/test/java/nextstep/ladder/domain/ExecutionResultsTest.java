package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ExecutionResultsTest {

    @DisplayName("ExecutionResults 생성자 테스트")
    @ParameterizedTest
    @MethodSource("provideExecutionResults")
    void executionResultTest(final List<String> executionResult, final List<String> expectedResult) {
        ExecutionResults results = ExecutionResults.of(executionResult);
        assertThat(results.getExecutionResults().size()).isEqualTo(expectedResult.size());
        assertThat(results.getExecutionResults().get(0).toString()).isEqualTo(ExecutionResult.of(executionResult.get(0)).toString());
        assertThat(results.getExecutionResults().get(1).toString()).isEqualTo(ExecutionResult.of(executionResult.get(1)).toString());
    }

    @DisplayName("ExecutionResults 생성할 때 null 입력 시 Exception 발생")
    @ParameterizedTest
    @NullSource
    void executionResultExceptionTest(final List<String> executionResult) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> ExecutionResults.of(executionResult));
    }

    private static Stream<Arguments> provideExecutionResults() {

        return Stream.of(
                Arguments.of(Arrays.asList("abc", "efg"), Arrays.asList("abc", "efg")),
                Arguments.of(Arrays.asList("hij", "klm"), Arrays.asList("hij", "klm"))
        );
    }
}
