package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ExecutionResultsTest {

    @ParameterizedTest
    @MethodSource("executionResultsProvider")
    @DisplayName("실행결과 일급 컬렉셔 생성을 확인한다")
    void create(List<ExecutionResult> executionResults) {
        assertThat(ExecutionResults.create(executionResults)).isInstanceOf(ExecutionResults.class);
    }

    public static Stream<Arguments> executionResultsProvider() {
        return Stream.of(
                arguments(
                        List.of(
                                ExecutionResult.create("실행결과1"),
                                ExecutionResult.create("실행결과2"),
                                ExecutionResult.create("실행결과3")
                        )
                )
        );
    }

}