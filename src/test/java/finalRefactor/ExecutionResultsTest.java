package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.ExecutionResult;
import step3.domain.ExecutionResults;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ExecutionResultsTest {

    @Test
    @DisplayName("Results 생성 테스트")
    void resultsTest() {
        assertThat(new ExecutionResults()).isEqualTo(new ExecutionResults());
    }

    @Test
    @DisplayName("Result input 값 리스트 변경 테스트")
    void stringToList() {
        ExecutionResults results = new ExecutionResults("꽝,5000");
        assertThat(results).isEqualTo(new ExecutionResults(Arrays.asList(new ExecutionResult("꽝"), new ExecutionResult("5000"))));
    }

    @Test
    @DisplayName("포지션에 따른 결과 값 반환")
    void returnOfOnePosition() {
        ExecutionResults results = new ExecutionResults(Arrays.asList(new ExecutionResult("꽝"), new ExecutionResult("5000")));
        assertThat(results.getOneResult(1)).isEqualTo(new ExecutionResult("5000"));
    }

}
