package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ExecutionResultsTest {
    private String[] executionResults;
    private int countOfPerson;

    @BeforeEach
    void setUp() {
        this.executionResults = "꽝,5000,꽝,3000".split(",");
        this.countOfPerson = 4;
    }

    @Test
    void create() {
        // when
        ExecutionResults expectedExecutionResults = ExecutionResults.from(executionResults, countOfPerson);

        // then
        assertThat(expectedExecutionResults).isEqualTo(ExecutionResults.from(executionResults, countOfPerson));
    }

    @Test
    @DisplayName("인원수만큼 실행결과를 입력하지않으면 예외가 발생한다")
    void size_exception() {
        assertThatThrownBy(() -> ExecutionResults.from(executionResults, 5))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("입력한 실행결과 개수만큼 실행결과가 생성된다")
    void create_size() {
        // when
        int expectedSize = ExecutionResults.from(executionResults, countOfPerson).getExecutionResults().size();

        // then
        assertThat(executionResults.length).isEqualTo(expectedSize);
    }

    @Test
    @DisplayName("원하는 index의 실행 결과가 반환된다")
    void getExecutionResult() {
        // given
        int index = 1;

        // when
        String executionResult = ExecutionResults.from(executionResults, countOfPerson).getExecutionResult(index);

        // then
        assertThat(executionResult).isEqualTo(executionResults[index]);
    }
}