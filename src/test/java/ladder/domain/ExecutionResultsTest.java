package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ExecutionResultsTest {

    @Test
    @DisplayName("[요구사항 1] 실행 결과의 사이즈와 참가자 수가 다르면 throw IllegalArgumentException")
    void 요구사항_1() {
        // given
        String[] executionResultsInput = {"Ari", "Rirang", "Arang"};
        int participantsSize = 5;

        // then
        Assertions.assertThatThrownBy(() -> new ExecutionResults(executionResultsInput, participantsSize))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("실행 결과의 사이즈는 참가자 수와 같아야 합니다.");
    }
}
