package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ExecutionResultTest {

    @Test
    @DisplayName("결과 속성을 가진 실행결과 인스턴스 생성 확인")
    void createExecutionResultTest() {
        assertThat(new ExecutionResult("5000")).isInstanceOf(ExecutionResult.class);
    }

}