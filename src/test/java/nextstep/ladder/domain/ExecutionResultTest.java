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
        ExecutionResult result = GamersTest.getGamers().matchResult(List.of("0", "1", "2", "3"));

        assertThat(result).isEqualTo(getExecutionResult());
    }

    public static ExecutionResult getExecutionResult() {
        Map<Gamer, Result> results = new HashMap<>();
        results.put(Gamer.of("pobi", 0), Result.from("0"));
        results.put(Gamer.of("honux", 1), Result.from("1"));
        results.put(Gamer.of("crong", 2), Result.from("2"));
        results.put(Gamer.of("jk", 3), Result.from("3"));
        return ExecutionResult.of(results);
    }
}