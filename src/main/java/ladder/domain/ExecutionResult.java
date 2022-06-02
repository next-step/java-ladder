package ladder.domain;

import java.util.Arrays;
import java.util.List;

public class ExecutionResult {
    private List<String> results;

    private ExecutionResult(List<String> results) {
        validateEmpty(results);
        this.results = results;
    }

    public static ExecutionResult from(String input) {
        String[] strings = input.split(",");
        return new ExecutionResult(Arrays.asList(strings));
    }

    public static ExecutionResult from(List<String> results) {
        return new ExecutionResult(results);
    }

    public String get(Position position) {
        return this.results.get(position.now());
    }

    private void validateEmpty(List<String> results) {
        if (results == null || results.isEmpty()) {
            throw new IllegalArgumentException("실행결과가 존재하지 않습니다.");
        }
    }

    public List<String> getResults() {
        return results;
    }

    @Override
    public String toString() {
        return "ExecutionResult{" +
                "results=" + results +
                '}';
    }
}
