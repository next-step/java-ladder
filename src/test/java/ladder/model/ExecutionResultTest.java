package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ExecutionResultTest {

    @Test
    @DisplayName("실행 결과 인스턴승 생성을 확인한다")
    void create() {
        assertThat(ExecutionResult.create("실행결과")).isInstanceOf(ExecutionResult.class);
    }

}