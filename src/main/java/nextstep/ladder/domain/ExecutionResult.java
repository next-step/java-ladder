package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-26 12:48
 */
public class ExecutionResult {
    private final List<String> executionResult;

    public ExecutionResult(List<String> executionResult) {
        this.executionResult = executionResult;
    }

    public List<String> getExecutionResult() {
        return this.executionResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExecutionResult that = (ExecutionResult) o;
        return Objects.equals(executionResult, that.executionResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(executionResult);
    }
}