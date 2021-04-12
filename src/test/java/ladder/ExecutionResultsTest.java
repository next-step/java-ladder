package ladder;

import ladder.domain.nextstep.ExecutionResults;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExecutionResultsTest {
    @ParameterizedTest(name = "실행결과_참여자수_Test")
    @MethodSource("실행결과_참여자수_Provider")
    public void 실행결과_참여자수_Test(int numberOfPlayers, String[] executionResults) {
        assertThatThrownBy(() -> new ExecutionResults(numberOfPlayers,executionResults))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("실행 결과는 참여자의 수와 일치해야 합니다.");
    }

    static Stream<Arguments> 실행결과_참여자수_Provider() {
        return Stream.of(
                Arguments.of(3,new String[]{"pobi","crong"}),
                Arguments.of(4,new String[]{"pobi","crong","dog","poo","apple"})
        );
    }

    @ParameterizedTest(name = "실행결과_참여자_이름길이_Test")
    @MethodSource("실행결과_참여자_이름길이_Provider")
    public void 실행결과_참여자_이름길이_Test(int numberOfPlayers, String[] executionResults) {
        assertThatThrownBy(() -> new ExecutionResults(numberOfPlayers,executionResults))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("실행 결과는 최대 5글자입니다.");
    }

    static Stream<Arguments> 실행결과_참여자_이름길이_Provider() {
        return Stream.of(
                Arguments.of(3,new String[]{"pobi","crong","notebook"}),
                Arguments.of(4,new String[]{"pobi","crong","dog","crayon"})
        );
    }
}
