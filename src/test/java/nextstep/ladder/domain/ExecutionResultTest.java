package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class ExecutionResultTest {

    @Test
    @DisplayName("정적 팩토리 메소드")
    void of() {
        ExecutionResult result = ExecutionResult.of(GamersTest.getGamers(), List.of("0", "1", "2", "3"));

        assertThat(result).isEqualTo(getExecutionResult());
    }

    private static ExecutionResult getExecutionResult() {
        Map<String, String> results = new HashMap<>();
        results.put("pobi", "0");
        results.put("honux", "1");
        results.put("crong", "2");
        results.put("jk", "3");
        return new ExecutionResult(results);
    }
}