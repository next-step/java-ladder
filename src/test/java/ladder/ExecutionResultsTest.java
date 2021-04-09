package ladder;

import ladder.domain.ExecutionResults;
import ladder.domain.Point;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExecutionResultsTest {
    @ParameterizedTest(name = "execution_Result_number_Of_Players_Test")
    @MethodSource("execution_Result_number_Of_Players_Provider")
    public void point_Next_RIGHT_Test(int numberOfPlayers, String[] executionResults) {
        assertThatThrownBy(() -> new ExecutionResults(numberOfPlayers,executionResults))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("실행 결과는 참여자의 수와 일치해야 합니다.");
    }

    static Stream<Arguments> execution_Result_number_Of_Players_Provider() {
        return Stream.of(
                Arguments.of(3,new String[]{"pobi","crong"}),
                Arguments.of(4,new String[]{"pobi","crong","dog","poo","apple"})
        );
    }

    @ParameterizedTest(name = "execution_Result_Length_Test")
    @MethodSource("execution_Result_Length_Provider")
    public void execution_Result_Length_Test(int numberOfPlayers, String[] executionResults) {
        assertThatThrownBy(() -> new ExecutionResults(numberOfPlayers,executionResults))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("실행 결과는 최대 5글자입니다.");
    }

    static Stream<Arguments> execution_Result_Length_Provider() {
        return Stream.of(
                Arguments.of(3,new String[]{"pobi","crong","notebook"}),
                Arguments.of(4,new String[]{"pobi","crong","dog","crayon"})
        );
    }
}
