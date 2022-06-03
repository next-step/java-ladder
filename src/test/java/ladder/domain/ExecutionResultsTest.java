package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ExecutionResultsTest {
    
    @Test
    @DisplayName("실행결과 index 를 통해 원하는 실행결과를 가지고 온다.")
    void getExecutionResultByIndex() {
        ExecutionResult e0 = new ExecutionResult("0");
        ExecutionResult e1 = new ExecutionResult("1");
        ExecutionResult e2 = new ExecutionResult("2");
        ExecutionResult e3 = new ExecutionResult("3");
        ExecutionResult e4 = new ExecutionResult("4");

        ExecutionResults executionResults = new ExecutionResults(List.of(e0, e1, e2, e3, e4));

        ExecutionResult result0 = executionResults.getResult(0);
        ExecutionResult result3 = executionResults.getResult(3);
        assertThat(result0).isEqualTo(e0);
        assertThat(result3).isEqualTo(e3);
    }

}