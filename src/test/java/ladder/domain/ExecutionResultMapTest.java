package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ExecutionResultMapTest {

    private Persons persons;
    private ExecutionResults executionResults;
    private Ladder ladder;

    @BeforeEach
    void setUp() {
        this.persons = Persons.from("pobi,honux,crong,jk".split(","));
        this.executionResults = ExecutionResults.from("꽝,5000,꽝,3000".split(","), 4);
        this.ladder = Ladder.of(3, 4, () -> Boolean.TRUE);
    }

    @DisplayName("사람 이름을 입력하면 최종 사다리 결과값이 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"pobi,5000", "honux,꽝", "crong,3000", "jk,꽝"})
    void getExecutionResult(String personName, String expectedExecutionResult) {
        // given
        ExecutionResultMap executionResultMap = ExecutionResultMap.of(persons, executionResults, ladder);

        // when
        String executionResult = executionResultMap.getExecutionResult(personName);

        // then
        assertThat(executionResult).isEqualTo(expectedExecutionResult);
    }

    @DisplayName("참여자에 없는 사람을 입력하면 예외 발생한다")
    @Test
    void getExecutionResult_exception() {
        ExecutionResultMap executionResultMap = ExecutionResultMap.of(persons, executionResults, ladder);

        assertThatThrownBy(() -> executionResultMap.getExecutionResult("test"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("참여하지 않은 사람은 입력할 수 없습니다.");
    }
}