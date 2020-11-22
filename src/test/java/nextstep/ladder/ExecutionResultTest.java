package nextstep.ladder;

import nextstep.ladder.domain.ExecutionsResults;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ExecutionResultTest {
    @Test
    @DisplayName("실행결과의 size는 입력된 input 실행결과와 size()가 같아야 한다.")
    void executionResultTest() {
        List<String> executionResultInput = Arrays.asList("꽝", "5000", "꽝", "3000");
        ExecutionsResults executionResults = ExecutionsResults.of(executionResultInput);
        assertThat(executionResults.size()).isEqualTo(executionResultInput.size());
    }
}
