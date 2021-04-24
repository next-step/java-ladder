package finalRefactor;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import finalRefactor.domain.ExecutionResult;

import static org.assertj.core.api.Assertions.assertThat;

public class ExecutionResultTest {

    @Test
    @DisplayName("Result 생성 테스트")
    void resultTest() {
        ExecutionResult result = new ExecutionResult("꽝");
        assertThat(result).isEqualTo(new ExecutionResult("꽝"));
    }
}
