package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExecutionResultsTest {

    List<String> executionResultsInput;

    @BeforeEach
    void setUp() {
        executionResultsInput = List.of("꽝", "5000", "꽝", "3000");
    }

    @Test
    @DisplayName("[요구사항 1] 입력한 실행 결과 수와 참가자 수가 같지 않으면 throw IllegalArgumentException")
    void 요구사항_1() {
        // given
        int participantSize = 3;

        // then
        assertThatThrownBy(() -> new ExecutionResults(executionResultsInput, participantSize))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력한 실행 결과 수와 참가자 수가 같아야 합니다.");
    }

    @Test
    @DisplayName("[요구사항 2] 입력한 실행 결과 수와 참가자 수가 같으면 정상적으로 ExecutionResults가 생성된다.")
    void 요구사항_2() {
        // given
        int participantSize = 4;

        // when
        ExecutionResults executionResults = new ExecutionResults(executionResultsInput, participantSize);

        // then
        assertThat(executionResults.getExecutionResultsSize()).isEqualTo(participantSize);
    }
}
