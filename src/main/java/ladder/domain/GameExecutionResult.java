package ladder.domain;

import java.util.Map;
import java.util.Objects;

public class GameExecutionResult {
    private final Map<String, String> executionMap;

    private GameExecutionResult(Map<String, String> executionMap) {
        validateGameExecutionResult(executionMap);
        this.executionMap = executionMap;
    }

    private void validateGameExecutionResult(Map<String, String> executionMap) {
        if (isEmpty(executionMap)) {
            throw new IllegalArgumentException("GameExecutionResult is Empty");
        }
    }

    private boolean isEmpty(Map<String, String> executionMap) {
        return executionMap == null || executionMap.isEmpty();
    }

    public static GameExecutionResult create(Map<String, String> executionMap) {
        return new GameExecutionResult(executionMap);
    }

    public Map<String, String> getExecutionResult() {
        return this.executionMap;
    }

    public String getResultByUserName(String name) {
        return executionMap.get(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameExecutionResult that = (GameExecutionResult) o;
        return Objects.equals(executionMap, that.executionMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(executionMap);
    }
}
